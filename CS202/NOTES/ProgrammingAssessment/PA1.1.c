#include<stdio.h>
#include<stdlib.h>

int main(int argc , char * argv[]){
 
  int i, j, total=1;
  for(i=2;i<=12;i++){
      total*=i;
      if(i%2==0)
	printf("%d\n",total);
  }
  
  return 0;
}