#include<stdio.h>
#include<stdlib.h>

int main(int argc,char*argv[]){
  int ch;
  while((ch=getc(stdin))!=EOF){
    if(ch=='a'||ch=='A')
      ch='@';
    if(ch=='i'||ch=='I')
      ch='1';
    if(ch=='r'||ch=='R')
      ch='4';
    printf("%c",ch);
  }
}
