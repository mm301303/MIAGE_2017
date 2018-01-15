// Gestionnaire de clavier
//Compiler avec l'option -lncurses

#include <curses.h>   //ajoute automatiquement <stdio.h>
#include <sys/types.h>
#include <sys/uio.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>
#include <string.h>


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

int main(int argc, char * argv[]) {

    int tin = open("tin",O_WRONLY); // Par défaut on écrit sur la sortie standard

//  int tin = open("tin",O_WRONLY | O_NONBLOCK); // Par défaut on écrit sur la sortie standard
/*    printf("tin fd is %d \n",tin);
    printf("%d \n",tin);
    printf ("err %d \n", errno);
    fprintf( stderr, "Error is %s (errno=%d)\n", strerror( errno ), errno );*/
  char c;

  initscr();            // Open curses
  noecho();             // ne pas faire l'echo sur l'écran des caractères tapés au clavier
  keypad(stdscr,TRUE);  // Traduction (lors des appels getch()) des caractères spéciaux -> <- etc en codes
                        // exemples: KEY_DOWN, KEY_UP, KEY_LEFT, KEY_RIGHT (voir man getch)

  while (true){ // Boucle infinie, sortie lorsque l'on ne peut plus écrire.
    c = gc(getch());
    if (c!=0) write(tin,&c,1);
  }
}
