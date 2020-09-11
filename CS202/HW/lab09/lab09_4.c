#include<stdio.h>
#include<stdlib.h>

int prime(unsigned long int y){
  int flag = 0;
  int check = y-1;
  
  // loop through decrement counter to check for prime number loop through all numbers possible to see if divisable
  while(check>1){
    if((y%check)==0){
      //printf("%d mod %d\n",y,check);
      flag = 1;
    }
    check--;
  }
  return flag;  
}




int main(){
  printf("x: ");
  unsigned long int x;
  scanf("%lu",&x);

  
  unsigned long int count;
  
  //count = prime(17);
  
  int i; 
  /*
  for(i=2;i<x;i++){
    if(prime(i)==0)
    printf("%d is %d\n\n",i,prime(i));
  }
  */
  for(i=2;i<x;i++){
    count=i;
    if(prime(count)==0){
      while(count<x){
	printf("%lu",count);
	count*=i;
	if(count<x)
	  printf("\t");
      }
      printf("\n");
    }
  }
      
  
    
    
    
  
  
  return 0; 
}
