CC=gcc
CFLAGS=-W -Wall
LDFLAGS=
EXEC= evallog1 evallog0 
SRC= evallog1.c evallog0.c
OBJ= $(SRC:.c=.o)

all: $(EXEC)

evallog0: $(OBJ) formula.o evallog0.o
	$(CC) -o $@ $^ $(LDFLAGS)

evallog1: $(OBJ) formula.o evallog1.o
	$(CC) -o $@ $^ $(LDFLAGS)

%.o: %.c
	$(CC) -o $@ -c $< $(CFLAGS)
	
clean:
	rm -rf *.o

mrproper: clean
	rm -rf $(EXEC)
