// Interface : encapsule gc et ga
//Compiler avec l'option -lncurses

#include <curses.h>   //ajoute automatiquement <stdio.h>
#include <sys/types.h>
#include <sys/uio.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>


#define XINIT 20
#define YINIT 3


char gc(int key){
  switch (key) { 
  case KEY_UP    : return 'u'; 
  case KEY_DOWN  : return 'd'; 
  case KEY_LEFT  : return 'l'; 
  case KEY_RIGHT : return 'r'; 
  case 'q'       : return 'q';
  }
  return (char) 0;
}

void maingc(){

  int tin = open("tin",O_WRONLY); // Par d�faut on �crit sur la sortie standard
  char c;

  //  initscr();            // fait par interface


  while (true){ // Boucle infinie, sortie lorsque l'on ne peut plus �crire.
    c = gc(getch());
    if (c!=0) write(tin,&c,1);
  } 
}


void ga(char instr[4]){
  if (strcmp(instr,"quit")==0) {
    endwin();   // Close curses
    exit(0);
  }
  mvaddch((int)(instr[2]),(int)(instr[1]),instr[3]);
  refresh();
}



void mainga(){

  int tout = open("tout",O_RDONLY);
  char instr[4];

  while (true){ // Boucle infinie, sortie depuis la fonction ga.
    read(tout,instr,4);
    ga(instr);
  } 
}



int main(int argc, char * argv[]) {


  initscr();            // Open curses
  noecho();             // ne pas faire l'echo sur l'�cran des caract�res tap�s au clavier
  keypad(stdscr,TRUE);  // Traduction (lors des appels getch()) des caract�res sp�ciaux -> <- etc en codes
                        // exemples: KEY_DOWN, KEY_UP, KEY_LEFT, KEY_RIGHT (voir man getch)

  // D�finition de l'�cran 
  addstr("+-----------------------------------+\n");
  addstr("|                                   |\n");
  addstr("|                                   |\n");
  addstr("|                                   |\n");
  addstr("|                                   |\n");
  addstr("+-----------------------------------+\n");
  // Pour une d�finition plus jolie voir border(), hline(); vline();

  // Lancement des gestionnaires de clavier et d'affichage
  if(fork()){mainga();}
  else {maingc();}
}
