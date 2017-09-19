#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>   

#include "M1.h"
#include "M2.h"

#define delta 0.000001
#define true 1
#define false 0

/*
On cherche a calculer pi/4 a l'aide de la formule Somme(((-1)^n)/2n+1))
*/

int main(void)
{
	double sum=0.0;
	double newSum=0.0;
	int n=0;


	double chrono = clock();

	printf("\n* * * * * * * * * * * * * * * * * *\n* with M1:\n");
	while(true)
	{	

		newSum = computeForN(n);

		sum += newSum;

		if((newSum>0)?newSum<delta:newSum>-delta)
		{

			printf("RESULTAT Pi/4 = %f\n",sum);
			printf("RESULTAT Pi = %f\n",sum*4);
			break;
		}
		n++;
	}

	chrono = clock()-chrono;
	printf("* time elapsed %f\n", chrono);


	printf("\n* * * * * * * * * * * * * * * * * *\n* with M2 (M3 sur le pdf TP1):\n");
	chrono = clock();
	double m2res=0.0;
	m2res=PIbyRandom(1/delta);

	printf("RESULTAT Pi/4 %.16f\n", m2res );
	printf("RESULTAT Pi = %f\n",m2res*4);
	

	chrono = clock()-chrono;
	printf("* time elapsed %f\n", chrono);

	printf("\n* * * * * * * * * * * * * * * * * *\n");
	return 0;

}