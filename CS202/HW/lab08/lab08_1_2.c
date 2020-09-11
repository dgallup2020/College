#include<stdio.h>
#include<stdlib.h>

int main(){
  FILE * f;
  f = stdin;
  
  int count = 0;
  int ch; 
  while((ch = fgetc(f)) != EOF){
   if(ch=='x')
     count++;
  }
  printf("%d\n",count);
  
  return 0;
}