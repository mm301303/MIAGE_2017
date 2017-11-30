#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>


/******************************************************************************************/

int left_subformula_length(char *formula) {

  if ( (formula[0] == '0') || (formula[0] == '1'))
    return 0;

  int i = 0;
  int j = 1;

  while (j != 0) {
    i = i + 1;
    
    if ((formula[i] == '0') || (formula[i] == '1'))
      j = j - 1;
    else if ((formula[i] == '&') || (formula[i] == '|'))
      j = j + 1;
    else {
      printf("%d  : parse error : character %c at position %d in %s not allowed\n" , getpid() , formula[i] , i , formula);
      exit(2);
    }
  }
  return i;
}

  
/******************************************************************************************/


char *left_subformula(char *formula) {

  int l = left_subformula_length(formula);
  char *res = (char *) calloc(l , sizeof(char));

  for(int i = 0; i< l; i++) res[i] = formula[i+1];

  return res;
}



/******************************************************************************************/

char *right_subformula(char *formula) {

  int l = left_subformula_length(formula);
  int l2 = strlen(formula);
  char *res = (char *) calloc( (l2-l-1) , sizeof(char));

  for(int i = 0; i< l2 - l - 1; i++) res[i] = formula[i+l+1];

  return res;

}


/******************************************************************************************/


char *random_formula(int nb_leaves_wished) {

  int formula_size = 2 * nb_leaves_wished - 1;
  char *res = (char *) calloc(formula_size , sizeof(char));
  int missing_leaves = 1;
  int nb_leaves = 0;
  int add_leaf;
  
  for(int i = 0; i< formula_size; i++) {
    
    if ((missing_leaves == 1) && (nb_leaves + missing_leaves < nb_leaves_wished)) add_leaf = 0;
    else if (nb_leaves + missing_leaves == nb_leaves_wished) add_leaf = 1;
    else add_leaf = ( (rand() % 2) == 0 );

    if (add_leaf) {
      res[i] = (rand() % 2 == 0) ? '0' : '1';
      nb_leaves++;
      missing_leaves--;
    } else {
      res[i] = (rand() % 2 == 0) ? '|' : '&';
      missing_leaves++;
    }
  }
  return res;
}
