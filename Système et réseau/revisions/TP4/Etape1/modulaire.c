//Compiler avec l'option -lncurses
#include <stdlib.h>
#include <string.h>
#include <curses.h>   //ajoute automatiquement <stdio.h>
#define XINIT 20
#define YINIT 3



// Gestionnaire de clavier
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


// Court-circuit
void cc(char c, char instr[4]){
  static int x = XINIT; // garde la valeur entre deux appels
  static int y = YINIT; 
  switch (c) { 
  case 'u':  y--; break; 
  case 'd':  y++; break;
  case 'l'  : x--; break;
  case 'r' : x++; break;
  case 'q'       : sprintf(instr,"quit"); return;
  }
  sprintf(instr,"%c%c%c%c",'w',(char) x,(char) y,'*');
}

// Gestionnaire d'affichage
void ga(char instr[4]){
  if (strcmp(instr,"quit")==0) {
    endwin();   // Close curses
    exit(0);
  }
  mvaddch((int)(instr[2]),(int)(instr[1]),instr[3]);
  refresh();
}



int main(int argc, char * argv[]) {
  char c;
  char instr[4];

  initscr();            // Open curses
  noecho();             // ne pas faire l'echo sur l'écran des caractères tapés au clavier
  keypad(stdscr,TRUE);  // Traduction (lors des appels getch()) des caractères spéciaux -> <- etc en codes
                        // exemples: KEY_DOWN, KEY_UP, KEY_LEFT, KEY_RIGHT (voir man getch)

  // Définition de l'écran 
  addstr("+-----------------------------------+\n");
  addstr("|                                   |\n");
  addstr("|                                   |\n");
  addstr("|                                   |\n");
  addstr("|                                   |\n");
  addstr("+-----------------------------------+\n");
  // Pour une définition plus jolie voir border(), hline(); vline();
  // Exemple : border(0,0,0,0,0,0,0,0);    // encadre l'écran tout entier

  // Position initiale
  mvaddch(YINIT,XINIT,'*');
  refresh();

  while (true){ // Boucle infinie, sortie depuis le gestionnaire d'affichage
    c=gc(getch());
    if (c!=0){
      cc(c,instr);
      ga(instr);
    }
  } 
}
