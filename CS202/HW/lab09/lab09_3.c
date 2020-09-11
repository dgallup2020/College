#include<stdio.h>
#include<stdlib.h>



int main(){
  unsigned long int x;
  printf("x: ");
  scanf("%lu",&x);
  //printf("%lu\n",x);
  
  unsigned long int Ptwo = 2;
  unsigned long int Pthree = 3;
  unsigned long int Pfive = 5;
  unsigned long int Pseven = 7;
  unsigned long int Peleven = 11;
  
  
  while(Ptwo <= x || Pthree <= x || Pfive <= x || Pseven <= x || Peleven <= x){ // use <=
    if(Ptwo <= x){ // use <=
      printf("%lu",Ptwo); // use \t
      Ptwo*=2;
      }
    
    if(Pthree <= x){
      printf("\t%lu",Pthree);
      Pthree*=3;
      }
      
    if(Pfive <= x){
      printf("\t%lu",Pfive);
      Pfive*=5;
      }
      
    if(Pseven <= x){
      printf("\t%lu",Pseven);
      Pseven*=7;
      }
      
    if(Peleven <= x){
      printf("\t%lu",Peleven);
      Peleven*=11;
      }
      
    printf("\n");
  
  }
  printf("\n");
  
  return 0; 
}

