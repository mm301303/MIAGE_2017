CC=gcc
CFLAGS=-W -Wall
LDFLAGS=
EXEC=bonjour
SRC= $(wildcard *.c)
OBJ= $(SRC:.c=.o)

all: $(EXEC)

bonjour: $(OBJ) bonjour_lib.o
	$(CC) -o $@ $^ $(LDFLAGS)

%.o: %.c
	$(CC) -o $@ -c $< $(CFLAGS)
	
clean:
	rm -rf *.o

mrproper: clean
	rm -rf $(EXEC)
