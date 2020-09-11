#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>



int main(int argc,char * argv[]){
  
  char ch = 'a';
  
  while(ch != ('Z'+1)){
    if(isalpha(ch))
      printf("%c - %3i\n",ch,ch);
    ch++;
  }
  
  
  
  
  return 0;
}
