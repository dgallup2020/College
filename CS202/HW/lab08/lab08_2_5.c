#include<stdio.h>
#include<stdlib.h>


unsigned int rotate(unsigned int a,unsigned int b){
  /*
  wrap p1 = (a>>(b*(8-c))) & (0xffffffff);
  wrap p2 = (a<<(b*c)) & (0xffffffff);
  
  
  */ // lets try this way
  //int c = b%32;
  b=b%32;
  //unsigned int p3,p4;
  //p3 = a<<b;
  //printf("this is p3 = %x\n", p3);
  //p4 = a>>(32-b);
  //printf("this is p4 = %x\n", p4);
  //return p3|p4; 
  return (a<<b)|(a>>(32-b));
  
  
  
  
  /*
int i=0;
wrap p3,p4,answer;
for(i=0;i<b;i++){
  p3 = (a>>31);
  printf("p3 %i= %#x\n",i,p3);
  p4 = (a<<1);
  printf("p4 %i= %#x\n",i,p4);
  answer = p3+p4;
}
  return answer;
  */
}




int main(){
  
  unsigned int test1;
  unsigned int move;
  
  printf("Integer in hex (e.g., 0x1234): ");
  scanf("%i",&test1);
  
  //printf("Your input %x\n",test1);
  
  printf("Integer from 0-31 in base 10: ");
  scanf("%i",&move);
  
  printf("rotated: 0x%x\n",rotate(test1,move));
  //printf("The input: %x : The shift %x\n",test1,move); number read in right
  //can't figure out 0x1234 input shift by 16

  return 0;
}
