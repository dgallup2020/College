#include<stdio.h>
#include<stdlib.h>


typedef unsigned short int flipp;

flipp reverse(flipp x){
  
  flipp p1 = (x & 0xff00)>>8;
  flipp p2 = (x & 0x00ff)<<8; //8 because each hex has 4 bits
  
  x=p1|p2; //OR adds both sides of the number
  
  return x;
}

int main(){
 
  /*
  printf("Integer in hex (e.g., 0x1234): ");
    //how to scanf for a custom data type

  flipp value = 0x7f3a;

  value = reverse(value);
  printf("%i\n",value);
  */
  /*
  flipp value2;
  printf("Integer in hex (e.g., ");
  scanf("%x\n",value2);
  printf("): reversed: \n");
  */
  
  
  flipp value3;
  scanf("%x",&value3);
  printf("Integer in hex (e.g., 0x1234): reversed: %#x\n",reverse(value3));
  return 0;
}
//test: if in 0x7f3a (32570) it is 0x3a7f (14975)

