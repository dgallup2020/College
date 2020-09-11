#include<stdio.h>
#include<stdlib.h>
#include<math.h>



int main(){
 
  unsigned int num;
  scanf("%u",&num);
  
  int bin = (1 << num);
  
  /*
  printf("%i\n",bin);
  
  printf("%x\n",bin);
  
  //printf("%0*d\n",num,1);
  printf("1");
  
  int i;
  for(i=0;i<num;i++)
    printf("0");
  
  printf("\n");
  */
  
  printf("i: 1");
  int i;
  for(i=0;i<num;i++)
    printf("0");
  printf("b = 0x%x = %u\n",bin,bin);
  
  return 0; 
}