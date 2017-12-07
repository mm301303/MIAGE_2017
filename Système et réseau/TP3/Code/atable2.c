#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>

#define N 1000000
#define M 10

int c[M];


/*****************************************/
// DECLARATION DE VERROUS A COMPLETER 

int use[2][2];

// FONCTIONS A COMPLETER

void enter_critical(int i, int j, int tid){}

void exit_critical(int i, int j, int tid){}

void init_mutexes(){}

void destroy_mutexes(){}

/*****************************************/


int randpos() {
  return (rand() % M);
}

void atomic_perm(int i, int j, int tid){

  if (i>j) {
    int t = i;
    i = j;
    j = t;
  }

  enter_critical(i,j,tid);

  int n;
  int fst;
  fst = c[i];
  for(n=i; n<j; n++) c[n] = c[n+1];
  c[j] = fst;

  exit_critical(i,j,tid);

}


void *threadfun(void *arg) {

  int n;
  int tid = *(int *)arg;

  for(n=0;n<N;n++){
    int i = randpos();
    int j = randpos();
    if (i!=j) atomic_perm(i,j,tid);
  }

  printf("Fin %d\n",tid);
  return NULL;

}


int main(int argc, char **argv){

  pthread_t t1,t2;

  srand(time(NULL));
  
  int tid[2];
  tid[0] = 0;
  tid[1] = 1;

  int i;
  for(i=0; i<M; i++) c[i] = i;
  
  init_mutexes();
  pthread_create(&t1,NULL,threadfun,&tid[0]);
  pthread_create(&t2,NULL,threadfun,&tid[1]);
  pthread_join(t1,NULL);
  pthread_join(t2,NULL);
  destroy_mutexes();

  for(i=0; i<M; i++) printf("c[%d] = %d\n",i,c[i]);
  printf("Fin main.\n");

}
