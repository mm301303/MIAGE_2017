/*
  Fichier : seconddeg.c

  Ebauche d'une solution au pb de la resolution d'une equation du
  second deg

  04/09/2017 -   G.MENEZ
 */
#include <stdio.h>  // pour printf et scanf
#include <math.h> // pour sqrt
#include <stdlib.h> // pour EXITSUCCESS

int main (void){

  double a, b, c ;               /*Coefficients reels*/
  double d = 0.0;              /*Delta*/

  /* Saisie au clavier */
  printf("Entrez une valeur de a : ");
  scanf("%lf", &a);
  printf("Entrez une valeur de b : ");
  scanf("%lf", &b);
  printf("Entrez une valeur de c : ");
  scanf("%lf", &c);

  d = pow(b,2)-(4*a*c);    /*Delta*/
  printf("d = %f\n", d);

  /* Des cas, des racines ... */ 
  if (d == 0)
    printf("Une racine dans R : %f\n", -b/(2*a));
  else if (d > 0){
    printf("Deux racines dans R :\n");
    printf("x1 = %f\n", (-b+sqrt(d))/(2*a));
    printf("x2 = %f\n", (-b-sqrt(d))/(2*a));
  }
  /* etc */

  return EXIT_SUCCESS;
}

