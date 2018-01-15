// Court-circuit
//Compiler avec l'option -lncurses

#include <curses.h>   //ajoute automatiquement <stdio.h>
#include <sys/types.h>
#include <sys/uio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>

#define XINIT 20
#define YINIT 3

 int x = XINIT; 
 int y = YINIT; 

void instruction(char instr[4]){
  sprintf(instr,"%c%c%c%c",'w',((char) x),((char) y),'*');  
}

void cc(char c, char instr[4]){
  switch (c) { 
  case 'u' :  y--;   instruction(instr); return; 
  case 'd' :  y++;   instruction(instr); return;
  case 'l' :  x--;   instruction(instr); return;
  case 'r' :  x++;   instruction(instr); return;
  case 'q' :  sprintf(instr,"quit"); return;
  }
  sprintf(instr,"erro");
}


int main(int argc, char * argv[]) {
  int tin = dup(STDIN_FILENO);
  int tout = dup(STDOUT_FILENO);
  char c;
  char instr[4];

  instruction(instr); // Initialisation du curseur

  while (true){ // Boucle infinie, sortie depuis le gestionnaire d'affichage
    if (strcmp(instr,"erro")!=0) write(tout,instr,4);
    read(tin,&c,1);
    cc(c,instr);
  }
} 
