#include<stdio.h>
#include<stdlib.h>

void bitoper(unsigned int a, unsigned int b){
  int and, or, xor;
  char *max = "";
  printf("(OR, AND, XOR) = (%d, %d, %d)\n",and = a|b,or = a&b,xor = a^b);
  if(and > or)
    max = "AND";
  else if(xor > or)
    max = "XOR";
  else
    max = "OR";
  printf("%s\n",max);
}


int main(int argc,char *argv[]){
  bitoper(atoi(argv[1]),atoi(argv[2]));
}
