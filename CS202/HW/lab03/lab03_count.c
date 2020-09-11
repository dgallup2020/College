#include <stdio.h>
#include <stdlib.h>

//argv #1/2

int main (int argc, char *argv[]){
  if(argc < 3){
    printf("Usage: ./a.out num1 num2\n");
    exit(0);
  }
  
  int start = atoi(argv[1]);
  int end = atoi(argv[2]);
  int i;
  for(i=start;i<=end;i++)
    printf("%d\n",i);
 //if(argc == 3){
   //printf("number of arguments %d\n",argc);
   //printf("arguments %s %s\n",argv[1],argv[2]);
 
  
}