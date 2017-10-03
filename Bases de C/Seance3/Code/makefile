CC = gcc
CFLAGS = -Wall -std=gnu99   

scanf_example_toupper: scanf_example_toupper.o
	$(CC)  scanf_example_toupper.o -o scanf_example_toupper


scanf_example_toupper.o: scanf_example_toupper.c 
	$(CC) -c scanf_example_toupper.c 

# Nettoyage léger: conserve les bibliothèques et les exécutables
clean:
	rm -f \#* *.o *.a *.so *.exe *~