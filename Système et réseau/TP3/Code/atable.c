#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>

#define N 1000000
#define M 100

int c[M];
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;


/*****************************************/
// DECLARATION DE VERROUS A COMPLETER 

// rien pour le moment


// FONCTIONS A COMPLETER

void enter_critical(int i, int j){
  int crit = pthread_mutex_lock(&mutex);

  if(crit) perror("pthread_mutex_lock");
}

void exit_critical(int i, int j){
  int crit = pthread_mutex_unlock(&mutex);
  if(crit) perror("pthread_mutex_lock");
}

void init_mutexes(){}

void destroy_mutexes(){
  pthread_mutex_destroy(&mutex);

}


/*****************************************/


int randpos() {
  return (rand() % M);
}

void atomic_swap(int i, int j){

  enter_critical(i, j);

  int t = c[i];  
  c[i] = c[j];
  c[j] = t;

  exit_critical(i, j);

}


void *threadfun(void *arg) {

  int n;

  for(n=0;n<N;n++){

    int i = randpos();
    int j = randpos();

    if (i!=j) atomic_swap(i,j);

  }

  printf("Fin %s\n",(char *)arg);
  return NULL;

}



int main(int argc, char **argv){

  pthread_t t1,t2;

  srand(time(NULL));
  
  int i;
  for(i=0;i<M;i++) c[i] = i;

  pthread_create(&t1,NULL,threadfun,"thread 1");
  pthread_create(&t2,NULL,threadfun,"thread 2");
  pthread_join(t1,NULL);
  pthread_join(t2,NULL);

  int sum = 0;

  for(i=0;i<M;i++) {
    printf("c[%d] = %d\n",i,c[i]);
    sum+=c[i];
  }
  printf("Fin main.%d\n",sum);

}
