CC = gcc
CFLAGS = -lm -Wall -Wextra -std=gnu99   

main.exe: main.o M1.o M2.o
	$(CC) -o $@ $^

main.o: main.c M1.o M2.o

M1.o: M1.c 

M2.o: M2.c 


# Nettoyage léger: conserve les bibliothèques et les exécutables
clean:
	rm -f \#* *.o *.a *.so *.exe *~