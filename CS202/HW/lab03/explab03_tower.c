#include<stdio.h>
#include<stdlib.h>

int main(){
  int row;
  int col;
  int val = 20;
  int count = 0;
  for(row=1;row<=val;row++){
     for(col=0;col<row;col++)
       printf("%c",'a'+count);
     count++;
     printf("\n");
     
  }
    
  
  
}