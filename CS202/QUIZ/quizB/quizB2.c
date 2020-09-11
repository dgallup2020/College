#include<stdio.h>
#include<stdlib.h>


int main(int argc, char *argv[]){
  
  int i;
  int sum=0;
  int prod=1;
  
  for(i=1;i<argc;i++){
    int a = atoi(argv[i]);
    sum+=a;
    prod*=a;
  }
  //printf("%d\n",atoi(argv[i]));
  printf("sum:     %d\nproduct: %d\n",sum,prod);
  
  return 0;
}