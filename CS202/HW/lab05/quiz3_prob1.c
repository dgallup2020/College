#include<stdio.h>
#include<stdlib.h>

int main(){


int a = 0x00; 

a |= 0xab; 
a &= 0x0f; 
a = ~a;    
a >> 2;    

printf("%d %x\n", a, a); 



}
