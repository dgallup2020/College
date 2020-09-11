#include<stdio.h>
#include<stdlib.h>


int main(int argc, char*argv[]){
  
  int ch; int count = 1;
  
  while((ch=getc(stdin))!=EOF){
  
   if(count%10==1)
     printf("%c",ch);
   if(ch=='\n')
     count++;
  }
  

  return 0;  
}
