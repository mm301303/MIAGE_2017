c#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <assert.h>
#include "formula.h"
#include <sys/types.h>
#include <sys/wait.h>


#define MAX_SLEEPING_TIME 3

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

    int pid_left = fork();
    int pid_right = pid_left ? fork() : 0;
    
    if (pid_left && pid_right) { // le pere 
      int status;
      
      waitpid(pid_right , &status , 0 );
      assert(WIFEXITED(status));
      int right = WEXITSTATUS(status);
      
      waitpid(pid_left , &status , 0 );
      assert(WIFEXITED(status));
      int left = WEXITSTATUS(status);
      
      if (operator == '|')
	res = left || right;
      else
	res = left && right;
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

  char *formula = (argc >=2) ? argv[1] : random_formula(5);
  int res = eval(formula);
  exit(res);

}
