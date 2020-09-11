#include<stdio.h>
#include<stdlib.h>

int main(int argc, char*argv[]){

  int x = 37, i = 0, v = 1;
  for(; x>v;i++){
    printf("%i, %i\n",i,x&v);
    v = v<<1;
  }
}
