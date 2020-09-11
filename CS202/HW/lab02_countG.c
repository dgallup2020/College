#include<stdio.h>
#include<stdlib.h>
//count to 20 using goto


int main(){
  int a = 1;
  loop:
    printf("%d\n",a);
    a++;
  if(a <= 20)
    goto loop;
  return 0; 
}