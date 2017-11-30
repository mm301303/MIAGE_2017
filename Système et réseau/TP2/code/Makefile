CC=gcc
CFLAGS=-W -Wall
LDFLAGS=
EXEC= evallog1 evallog0 evallog3
SRC= wildcard(*.c)
OBJ= $(SRC:.c=.o)

all: $(EXEC)

evallog0: formula.o evallog0.o
	$(CC) -o $@ $^ $(LDFLAGS)

evallog1: formula.o evallog1.o
	$(CC) -o $@ $^ $(LDFLAGS)

evallog3: formula.o evallog3.o
	$(CC) -o $@ $^ $(LDFLAGS)

%.o: %.c
	$(CC) -o $@ -c $< $(CFLAGS)
	
clean:
	rm -rf *.o

mrproper: clean
	rm -rf $(EXEC)
