#include<stdio.h>
#include<stdlib.h>



int howbig(int x){
  int check = 1;
  int value = 0;
  int i;
  for(i=0;i<sizeof(unsigned int);i++){
    if(check&x)
      value = check&x;
    check=check<<1;
  }
  return value;
}


int main(int argc,char*argv[]){
  printf("%d\n",howbig(atoi(argv[1])));
}
