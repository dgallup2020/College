#include<stdio.h>
#include<stdlib.h>

int main(int argc,char*argv[]){
 int i; int sum = 0;
 for(int i = 100;i <= 200; i+=2){
   sum+=i*i; 
   printf("%i\n", sum);
 }
 
 
 return 0;
}
