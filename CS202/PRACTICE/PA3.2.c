#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>

int main(int argc,char* argv[]){

  int ch;int flag =0;
  while((ch=fgetc(stdin))!=EOF){
    if(!isalpha(ch)){
      flag = 1;
      break;
    }
  }
  if(flag)
    printf("not\n");
  else
    printf("word\n");
}
