#include<stdlib.h>
#include<stdio.h>

int justOne(unsigned int x){
  return (x>>8)&0xff;
}

int main(int argc, char *argv[]){


  printf("%x\n",justOne(0x11223344));
  printf("%d\n",justOne(0x11223344));
  return 0;
}
