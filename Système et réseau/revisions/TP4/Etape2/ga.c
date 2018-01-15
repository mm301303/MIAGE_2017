// Gestionnaire d'affichage
//Compiler avec l'option -lncurses

#include <curses.h>   //ajoute automatiquement <stdio.h>
#include <sys/types.h>
#include <sys/uio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <stdlib.h>
#include <errno.h>



void ga(char instr[4]){
  if (strcmp(instr,"quit")==0) {
    endwin();   // Close curses
    exit(0);
  }
  mvaddch((int)(instr[2]),(int)(instr[1]),instr[3]);
  refresh();
}



int main(int argc, char * argv[]) {
  int tout = open("tout",O_RDONLY);
/*  printf("%tout fd is d \n",tout);
  printf("errno is %d and fd is %d \n",errno,tout);
  fprintf( stderr, "Error is %s (errno=%d)\n", strerror( errno ), errno );*/
  
  char instr[4];

  initscr();            // Open curses

  // Définition de l'écran 
  addstr("+-----------------------------------+\n");
  addstr("|                                   |\n");
  addstr("|                                   |\n");
  addstr("|                                   |\n");
  addstr("|                                   |\n");
  addstr("+-----------------------------------+\n");
  // Pour une définition plus jolie voir border(), hline(); vline();
  // Exemple : border(0,0,0,0,0,0,0,0);    // encadre l'écran tout entier

  while (true){ // Boucle infinie, sortie depuis la fonction ga.
    read(tout,instr,4);
    ga(instr);
  }
}
