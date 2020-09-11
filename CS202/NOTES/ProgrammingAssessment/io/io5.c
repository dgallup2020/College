#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>

int main(int argc,char*argv[]){

  int c;
  while((c=fgetc(stdin))!=EOF){
    if(isalpha(c) || isspace(c))
      printf("%c",c);
  }

return 0;
}
