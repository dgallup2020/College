#include<stdio.h>
#include<stdlib.h>

int dupped(unsigned int x){
 int i; unsigned int value = x&0xff; int flag = 1;
 for(i=0;i<3;i++){
   x=x>>8;
   if(value!=(x&0xff))
     flag = 0;
 }
 // printf("%x\n",value==x);
 return flag; 
}

int main(int argc,char*argv[]){
 printf("%i\n",dupped(0x12121212)); //will return 1
 printf("%i\n",dupped(0xfafafafa)); //will return 1
 printf("%i\n",dupped(0x12121221)); //will return 0
 printf("%i\n",dupped(0x12121200)); //will return 0
 // printf("%x\n",0xfafafafa & 0xff);
 return 0; 
}