#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>

int main(int argc, char*argv[]){
  int ch, lines = 0, words = 0, chars = 0, prev = 0;
  while((ch=getc(stdin))!=EOF){
    if(ch=='\n')
      lines++;
    if(isspace(ch) && !isspace(prev))
      words++;
    chars++;
    prev = ch;
  }
  printf("lines = %d || words = %d || chars =   %d\n",lines,words,chars);

}
