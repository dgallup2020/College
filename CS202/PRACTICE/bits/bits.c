#include <stdio.h>

int main(int argc, char *argv[]) {

  printf("%x\n", ~ 0x5);
  unsigned char c = 0x5;
  c = ~ c;
  printf("%x\n", c);

  c = 0xf << 8;
  printf("%x\n", c);
  
  return 0;
}