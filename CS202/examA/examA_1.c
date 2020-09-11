// note: compile like: gcc examA_1.c -lm
//       or use Makefile
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(int argc, char *argv[]) {

  const int h = 30;
  int lengths[h];
  for(int i=0; i < h; i++) lengths[i] = sin(3.14*i/h)*h*2;

  // you to do: print h many lines, with i-th being length[i] many '-' characters
  int i,j;
  for(i=0; i < h; i++)
    for(j=0; j < lengths[i]; j++)
      printf("-");
  printf("\n");
  
  return 0;
}