#include<stdio.h>
#include<stdlib.h>

int main(int argc, char*argv[]){
  int ch;
  while((ch=getc(stdin))!=EOF){
    if(ch=='t'||ch=='T'||ch=='h'||ch=='H'||ch=='e'||ch=='E'){
      ch='*';
    }
    printf("%c",ch);
  }
}
