#include<stdio.h>
#include<stdlib.h>

int main(int argc, char *argv[]){

  int count = atoi(argv[1]);
  int i;
  int prevsum = 0;
  int newsum = 0;
  int add = 0;
  
  
  for(i=0;i<count;i++){
    printf("Type an integer: ");
    scanf("%d",&add);
    prevsum = newsum;
    newsum = prevsum + add;
    printf("  partial sum: %d\n",newsum);
    if(newsum > 2*prevsum)
      printf("  Woah big fella.\n");
    
   // printf("new sum = %d -- prev sum = %d\n",newsum,prevsum);
  }



}
