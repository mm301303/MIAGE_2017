CC=gcc
CFLAGS=-W -Wall -pthread
LDFLAGS= -lpthread
EXEC= echauffement atable
SRC= wildcard(*.c)
OBJ= $(SRC:.c=.o)

all: $(EXEC)

echauffement: echauffement.o
	$(CC) -o $@ $^ $(LDFLAGS)

atable: atable.o
	$(CC) -o $@ $^ $(LDFLAGS)

%.o: %.c
	$(CC) -o $@ -c $< $(CFLAGS)
	
clean:
	rm -rf *.o

mrproper: clean
	rm -rf $(EXEC)
