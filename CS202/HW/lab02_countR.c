#include <stdio.h>
#include <stdlib.h>

void rec(int a){
  printf("%d\n",a);
  a++;
  if(a==21)
    exit(0);
  rec(a);
}

int main(){
  int i = 1;
  rec(i);
  return 0;
  
}
