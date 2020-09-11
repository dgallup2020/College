#include<stdio.h>
#include<stdlib.h>

int main(int argc, char* argv[]){
  int i, total = 1;
  for(i=1;i<=10;i++)
    total*=3;
  printf("%d\n",total);
}
