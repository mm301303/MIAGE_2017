#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <assert.h>
#include <sys/wait.h>
#include <sys/types.h>
#include "formula.h"

#define MAX_SLEEPING_TIME 3

/******************************************************************************************/

int eval(char *formula ) {

  // on affiche ce qu'on va faire et on s'endort

  int sleeping_time = rand() % MAX_SLEEPING_TIME;
   printf("evalue %s en commencant par dormir %d secondes\n" , formula , sleeping_time);
   sleep( sleeping_time);

  // on commence l'Ã©valuation de la formule

  char *formula_left = left_subformula(formula);
  char *formula_right = right_subformula(formula);
  char operator = formula[0];
  int res;


  if (operator == '0'){    
      res = 0;
  }
  else if (operator == '1'){ 
       res = 1;
  }
  else {
    pid_t pid;
    int status;
    int left;
    int right;

    // PARTIE GAUCHE

    if((pid = fork()) == -1) {
           perror("fork");
           exit(EXIT_FAILURE);
         }

    // Fils
         if(pid == 0) {
           exit(eval(formula_left));
         } else {
           if (waitpid(pid, &status, 0) == -1) {
             perror("wait :");
             exit(EXIT_FAILURE);
           }

      left = WEXITSTATUS(status);
      if(left=='1'||left=='0'){
        
      }
          }

    // PARTIE DROITE

       if((pid = fork()) == -1) {
             perror("fork");
             exit(EXIT_FAILURE);
           }

    // Fils
         if(pid == 0) {
           exit(eval(formula_right));
         } else {
           if (waitpid(pid, &status, 0) == -1) {
             perror("wait :");
             exit(EXIT_FAILURE);
           }

      right = WEXITSTATUS(status);
          }

    if (operator == '|')
           {
            res = (left || right );
          }
         else if (operator == '&')
          {
            res = (left && right );
          }
         else assert(0);

  }

   printf("evaluation de %s terminee : %d\n" , formula , res); 
   return res ;
}



/******************************************************************************************/

int main (int argc, char **argv) {

  srand(time(NULL)); // initialisation de rand

  char *formula = (argc >=2) ? argv[1] : random_formula(5);
   int res = eval(formula);
   exit(res);

}
