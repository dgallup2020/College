#include <stdio.h>
#include <stdlib.h>

// you to do: roundPower2 function
int roundPower2(long int value){
  
  int i, highbit;
  for(i=0; i < ((sizeof(value)*8)-1)/2; i++){
    
    int check = 1 << i;
    if( (value & check) != 0)
      highbit = value & check;
    //printf("%d\n",highbit);
  }
  return highbit;
}

int main(int argc, char *argv[]) {

  printf("Integer:                  ");
  long int x;
  scanf("%li", &x);

  long int y = roundPower2(x);
  printf("Round down to power of 2: %li\n", y);
  
  return 0;
}