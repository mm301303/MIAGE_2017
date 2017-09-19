#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include "M2.h"
#ifndef RAND_MAX
#define RAND_MAX 32767
#endif

double PIbyRandom(int all)
{	
	double x=0.0, y=0.0;
	double in=0.0, out=0.0;

	for(int i=0; i<all; i++){
		x=((double)(rand()&RAND_MAX)/(double)(RAND_MAX+0.5));
		y=((double)(rand()&RAND_MAX)/(double)(RAND_MAX+0.5));
		
		if((x*x)+(y*y)<=1){
			in++;
		}else {
			out++;
		}
	}
	printf("in :%f\n",in );
	printf("out :%f\n",out );
	return in/all;
}


