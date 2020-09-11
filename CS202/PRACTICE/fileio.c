#include<stdio.h>
#include<stdlib.h>


int main(int argc, char*argv[]){
  int ch, prev = 0;
  while((ch=getc(stdin))!=EOF){
    if(prev == '\n'){
      prev = ch;
      continue;
      }
    printf("%c",ch);
    prev = ch;
  }

}
