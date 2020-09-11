#include<stdlib.h>
#include<stdio.h>

int pal(unsigned char x){
  int b1 = ((1<<4)&x)==((1<<3)&x)<<1;
  //printf("%d\n",b1);
  int b2 = ((1<<5)&x)==((1<<2)&x)<<3;
  int b3 = ((1<<6)&x)==((1<<1)&x)<<5;
  int b4 = ((1<<7)&x)==(1&x)<<7;
  return b1 && b2 && b3 && b4;

}

int main(int argc,char*argv[]){
  if(argc<2){
    printf("arg 2 is your input\n");
    exit(0);
  }
  printf("%d\n",pal((char)atoi(argv[1])));
//  printf("%d\n",pal(0b00011000));

}
