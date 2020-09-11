// note: compile like: gcc examA_1.c -lm
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int isPrime(int n) {
  if (n < 2) return 0;
  if (n % 2 == 0) return 0;
  for(int i=3; i*i <= n; i+=2) {
    if (n % i == 0) return 0;
  }
  return 1;
}

int main(int argc, char *argv[]) {
  /*
    Write code to print the prime #s between 100 and 200, from
    largest to smallest. You should use a loop and the isPrime function.
   */
   int i;
   for(i=200;i>100;i--){
      if(isPrime(i))
	printf("%d\n",i);
   }  
  
  
  
  return 0;
}