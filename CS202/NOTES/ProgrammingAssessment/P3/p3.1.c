#include <stdio.h>
#include <stdlib.h>

#include <math.h>

int main(int argc, char*argv[]){
  const int h = 30;
  int lengths[h];
  int i;
  for(i = 0; i < h; i++){
    lengths[i] = sin((3.14*i/h))*h*2;
    int j=0;
    for(j;j<lengths[i];j++)
      printf("-");
    printf("\n");
    
  }
  return 0;
}