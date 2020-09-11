#include <stdio.h>
#include <stdlib.h>


int main(int argc, char * argv[]){
 int total = 1; int j; int base = 1;
  
 while(total<432){
    total = 1;
    for(j=0;j<3;j++)
	total*=base;
    printf("%d\n",total);
    base++;
  }
  return 0;
}