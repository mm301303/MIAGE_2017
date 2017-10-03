#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define true 1

int chartoascii(char c){
	int v = c;
	return v;
}

char mytoupper(char c){
	return (char) chartoascii(c)-32;
}



int main(void){
	char lettre, lettreupper1, lettreupper2, lettreupper3, lettre4, ok;
		
	while(true){
		lettre='0', lettreupper1='0', lettreupper2='0', lettreupper3='0',lettre4='0', ok='0';
		printf("* entrez une lettre : \n");
		scanf("%c*", &lettre);		
		if(lettre>96 && lettre<123 ){
			lettreupper1 = lettre - (97-65);
			lettreupper2 = toupper(lettre);
			lettreupper3 = lettre - ('a'-'A');
			lettre4 = mytoupper(lettre);
			printf("1 : %c, 2 : %c, 3 : %c , 4 (mytoupper) : %c\n", lettreupper1, lettreupper2, lettreupper3, lettre4);
		}else{
			printf("%c", lettre);
		}	
	}
}

