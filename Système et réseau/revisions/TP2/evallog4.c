#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <assert.h>
#include "formula.h"
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>

#define MAX_SLEEPING_TIME 3

int pid_left = 0;
int pid_right = 0;

void tue_fils_inutile(int pid_got) {
  int pid_killed = (pid_got == pid_left) ? pid_right : pid_left ;
  printf("%d tue %d\n" , getpid() , pid_killed);
  kill(pid_killed,SIGUSR1);
}

void tue_tous_les_fils() {
  if (pid_left && pid_right) {
    printf("%d tue %d et %d\n" , getpid() , pid_left , pid_right);
    kill(pid_left,SIGKILL);
    kill(pid_right,SIGUSR1);
  }
} 

typedef void sigfunc(int);
  
void sig_handler(int signo)
{
  if (signo == SIGUSR1) {
    printf("%d tué\n", getpid() );
    tue_tous_les_fils();
    exit(0);
  }
}


/******************************************************************************************/

int eval(char *formula ) {

  // on affiche ce qu'on va faire et on s'endort

  int sleeping_time = rand() % MAX_SLEEPING_TIME;
  printf("%d evalue %s en commencant par dormir %d secondes\n" , getpid() , formula , sleeping_time);
  sleep( sleeping_time);

  // on commence l'évaluation de la formule

  char *formula_left = left_subformula(formula);
  char *formula_right = right_subformula(formula);
  char operator = formula[0];
  int res;
  

  if (operator == '0')    
    res = 0;

  else if (operator == '1') 
    res = 1;

  else {

    pid_left = fork();
    pid_right = pid_left ? fork() : 0;
    
    if (pid_left && pid_right) { // le pere 

      int status;
      int pid1 = wait(&status);
      assert(WIFEXITED(status));
      assert ( (pid1 == pid_left) || (pid1 == pid_right) );
      int sub1 = WEXITSTATUS(status);
      
      if (sub1 && (operator == '|'))  { // ou paresseux
	res = 1;
	// on tue le fils inutile
	tue_fils_inutile(pid1);
      } else if (!sub1 && (operator == '&')) { // et paresseux
	res = 0;
	// on tue le fils inutile
	tue_fils_inutile(pid1);
      } else { // on doit attendre le deuxieme fils pour conclure
	
    	int pid2 = wait(&status);
    	assert(WIFEXITED(status));
    	assert ( (pid2 == pid_left) || (pid2 == pid_right) );
    	int sub2 = WEXITSTATUS(status);
    	if (operator == '|')
    	  res = sub1 || sub2;
    	else
    	  res = sub1 && sub2;
      }
    }
    else if (pid_left) { // le fils droit

      eval(formula_right);
    } else { // le fils gauche

      eval(formula_left);
    }
  }
  
  printf("%d : evaluation de %s terminee : %d\n" , getpid() , formula , res); 
  exit(res);
}



/******************************************************************************************/

int main (int argc, char **argv) {

  srand(time(NULL)); // initialisation de rand

  signal(SIGUSR1, sig_handler); // on attache le handler de signaux a SIGUSR1

  char *formula = (argc >=2) ? argv[1] : random_formula(5);
  int res = eval(formula);
  exit(res);

}
