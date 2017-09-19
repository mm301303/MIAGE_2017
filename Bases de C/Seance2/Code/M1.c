#include <stdio.h>
#include <math.h>

#include "M1.h"

/*
Calcule la formule au cran n et retourne un double
*/

double computeForN(int n)
{	
	double res;
	res = (n%2==0)?(1./((2*n)+1.)):(-1./((2*n)+1.));
	//printf("%d - %f \n", n, res);
	return res;
}


