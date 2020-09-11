#include<stdio.h>
#include<stdlib.h>

int main(){
  FILE * f;
  f = stdin;
  
  int ch; 
  while((ch = fgetc(f)) != EOF){
   if(isalpha(ch) || (ch == ' ') || (ch == '\n') )
     printf("%c",ch);
  }

  return 0;
}