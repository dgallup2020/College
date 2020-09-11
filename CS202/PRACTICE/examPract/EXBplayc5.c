#include<stdio.h>
#include<stdlib.h>

int main(int argc, char*argv[]){

int x[5] = {14, 15, 16, 17, 18};
int *y = (int *) malloc(5*sizeof(int));
int *z = &x[0];

y[0] = x[1] = 30;
z[0] = x[2] = 5;
y++;z++; y[0] = z[0] = x[3];
printf("%i, %i, %i, ",x[0],x[1],x[2]);
printf("%i, %i, %i, \n",y[0],z[0],x[4]);


}
