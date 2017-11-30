#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <assert.h>
#include "formula.h"

#define MAX_SLEEPING_TIME 3

/******************************************************************************************/

int eval(char *formula ) {

  // on affiche ce qu'on va faire et on s'endort

  int sleeping_time = rand() % MAX_SLEEPING_TIME;
  printf("evalue %s en commencant par dormir %d secondes\n" , formula , sleeping_time);
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
    int left;

    int pid = fork();

    if(pid==0){
      int left = eval(formula_left);
      printf("I am the father\n");
    }else{
      exit(eval(formula_right));//le fils va mourrir en renvoyant son résultat
      printf("I am the son\n");
    }
    int right = waitpid(pid);
    printf("the son is dead\n");

    if (operator == '|')
      res = (left || right );
    else if (operator == '&')
      res = (left && right );
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
