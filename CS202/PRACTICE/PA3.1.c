#include<stdio.h>
#include<stdlib.h>

int main(int argc, char*argv[]){
  int i,power;
  for(i=1;(power = (7*i)*(7*i)) < 1000000;i++)
    printf("%d\n",power);


}
