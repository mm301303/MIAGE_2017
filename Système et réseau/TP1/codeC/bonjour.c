#include <stdio.h>
#include <stdlib.h>
#include "bonjour_lib.h"
#define CURRENT_YEAR 2017 
//current year should be changed each year for coherence... \o/

int main(int argc, char *argv[]){
    /* exo 12 et 13
    printf("%s\n",message);

    if(argc>=1)
    for(int i=1; i<argc; i++){
    	printf("arg %d %s\n",i , argv[i]);
    }
    else printf("no args");
    */
    char* name = malloc(100*sizeof(char));
    char* sexe = malloc(100*sizeof(char));
    int annee;
    printf("%s\n",message);
    printf("Quel est votre nom, Kevin ?\n");
    scanf("%s", name);
    fflush(stdin);
    printf("Ca vous dérange que je vous appelle Kevin, %s ?\n", name);
    printf("Quel est votre sexe, Kevin ? (homme/femme)\n");
    scanf("%s", sexe);
    printf("Quel est votre annee de naissance, Kevin ?\n");
    scanf("%d", &annee);

    greet(name, sexe, annee);

    exit(0);
}

int greet(char* name, char* sexe, int annee){

    int age = CURRENT_YEAR - annee;
    char* politesse = (strcmp(sexe, "homme")==0)?"Monsieur":"Madame" ;
    printf("bonjour %s %s, vous paraissez plus vieux que vos %d ans !\n", politesse, name, age );
    exit(0);
}