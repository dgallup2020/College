#include<stdio.h>
#include<stdlib.h>


int main(){
  printf("i: ");
  unsigned int num;
  scanf("%u",&num);
  
  
  int k;
  for(k=0;k<=num;k++){
    printf("%u\n",1<<k);
  }
  
  
  return 0; 
}