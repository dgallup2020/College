#include <stdio.h>
#include <stdlib.h>

/*
  examB to do - create a function that has parameters - 
    unsigned integer x, unsigned character c,
  and returns the unsigned integer resulting from or-ing c 
  into each of x's 4 bytes.
 */

int orTogether(unsigned int x, unsigned char c){
  
  int b1 = x & 0x000F;
  b1 = x | c;
  int b2 = x & 0x00F0;
  b2 = ((b2>>8) | c)<<8;
  int b3 = x & 0x0F00;
  b3 = ((b3>>16) | c)<<16;
  int b4 = x & 0xF000;
  b4 = ((b2>>24) | c)<<24;
  return b1|b2|b3|b4;

}


int main(int argc, char *argv[]) {

  printf("Up to 4 bytes of hex: 0x");
  unsigned int x;
  scanf("%x", &x);

  printf("One byte of hex:      0x");
  unsigned char c;
  scanf("%hhx", &c);
  
  unsigned int y = orTogether(x,c);
  printf("or'ed together:       0x%x\n", y);
  
  return 0;
}