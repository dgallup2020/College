#include <stdio.h>
#include <stdlib.h>


int justone(unsigned int x){

  int mask = 11 << 7;
  int result = mask & x;
  //return result >> 7;
  printf("%d\n");
}

int main(int argc,char* argv[]){

  justone(11223344);

  return 0; 
}


