#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>
#include <unistd.h>

#define N 1000000
#define M 10

int c[M];

pthread_mutex_t mutexI = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t mutexJ = PTHREAD_MUTEX_INITIALIZER;



//pthread_cond_t cond[M];


/*****************************************/
// DECLARATION DE VERROUS A COMPLETER 

// rien pour le moment


// FONCTIONS A COMPLETER

void enter_critical(int i, int j){
  if(i!=j){
    if(cond[i]==NULL) {
      //cond[i] = PTHREAD_COND_INITIALIZER;
    }else{ 
      pthread_cond_wait (&cond[i], &mutexI);

    }
    if(cond[j]==NULL) {
      //cond[j] = PTHREAD_COND_INITIALIZER;
    }else{
      pthread_cond_wait (&cond[j], &mutexJ);
    }

    int critI = pthread_mutex_lock(&mutexI);
    if(critI) perror("pthread_mutex_lock");
    int critJ = pthread_mutex_lock(&mutexJ);
    if(critJ) perror("pthread_mutex_lock");
  }
}

void exit_critical(int i, int j){
  if(i!=j){
    //pthread_cond_signal (&cond[i]);
    //pthread_cond_signal (&cond[j]); 


    int critI = pthread_mutex_unlock(&mutexI);
    if(critI) perror("pthread_mutex_unlock");
    int critJ = pthread_mutex_unlock(&mutexJ);
    if(critJ) perror("pthread_mutex_unlock");
  }
}

void init_mutexes(){
  for(int i=0; i<M; i++){
    //cond[i] = PTHREAD_COND_INITIALIZER;
  }
}

void destroy_mutexes(){
  pthread_mutex_destroy(&mutexI);
  pthread_mutex_destroy(&mutexJ);

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
  for(i=0;i<M;i++) {
    c[i] = i;
  }

  pthread_create(&t1,NULL,threadfun,"thread 1");
  pthread_create(&t2,NULL,threadfun,"thread 2");
  pthread_join(t1,NULL);
  pthread_join(t2,NULL);

  for(i=0;i<M;i++) printf("c[%d] = %d\n",i,c[i]);
  printf("Fin main.\n");

}
