#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>

#define N 1000000
#define M 10

int c[M];


/*****************************************/
// DECLARATION DE VERROUS A COMPLETER 

pthread_mutex_t mut[M];

// FONCTIONS A COMPLETER

void enter_critical(int i, int j){
  // il faut que tous les threads verrouillent dans le même ordre (par exemple croissant)
  // pour éviter les interblocages
  int min = (i<j) ? i : j;
  int max = (i<j) ? j : i;
  pthread_mutex_lock(&mut[min]);
  pthread_mutex_lock(&mut[max]);  
  
 // pthread_mutex_lock(&mut[i]);
  //pthread_mutex_lock(&mut[j]);  
}

void exit_critical(int i, int j){
  // l'ordre pour déverouiller n'est pas important
  pthread_mutex_unlock(&mut[i]);
  pthread_mutex_unlock(&mut[j]);    
}

void init_mutexes(){
  int i;
  for(i=0; i<M; i++) pthread_mutex_init(&mut[i],NULL);
}

void destroy_mutexes(){
  int i;
  for(i=0; i<M; i++) pthread_mutex_destroy(&mut[i]);
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

  init_mutexes();

  pthread_create(&t1,NULL,threadfun,"thread 1");
  pthread_create(&t2,NULL,threadfun,"thread 2");
  pthread_join(t1,NULL);
  pthread_join(t2,NULL);

  destroy_mutexes();

  for(i=0;i<M;i++) printf("c[%d] = %d\n",i,c[i]);
  printf("Fin main.\n");

}
