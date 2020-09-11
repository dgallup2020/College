#include<stdio.h>
#include<stdlib.h>

int main(int argc,char * argv[]){
  
  int n;
  int sum=0;
  for(n=1;n<=37;n+=2){
    sum+=n*n;
    //printf("%i squared = %i\n",n,n*n);
  }
  //printf("FINAL SUM = %i\n",sum);
  printf("%d\n",sum);
 return 0; 
}