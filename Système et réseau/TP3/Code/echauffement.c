#include <stdio.h>
#include <pthread.h>
#include <unistd.h>
#define N 1000000

int c = 0;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

/*****************************************/
// DECLARATION DE VERROUS A COMPLETER 

// rien pour le moment


// FONCTIONS A COMPLETER

void enter_critical(){
  int crit = pthread_mutex_lock(&mutex);
  if(crit) perror("pthread_mutex_lock");
}

void exit_critical(){
  int crit = pthread_mutex_unlock(&mutex);
  if(crit) perror("pthread_mutex_lock");
}

void init_mutexes(){
  //rien
}

void destroy_mutexes(){
  pthread_mutex_destroy(&mutex);
}

/*****************************************/

void *threadfun(void *arg) {

  int i;

  for(i=0;i<N;i++){
    enter_critical();
    //sleep(1);
    c++;
    exit_critical();
  }

  printf("Fin %s\n",(char *)arg);
  return NULL;

}


int main(int argc, char **argv){

  pthread_t t1,t2;

  init_mutexes();
  pthread_create(&t1,NULL,threadfun,"thread 1");
  pthread_create(&t2,NULL,threadfun,"thread 2");
  pthread_join(t1,NULL);
  pthread_join(t2,NULL);
  printf("c=%d\nFin main.\n",c);
  destroy_mutexes();

}


