#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>

int main(int argc,char*argv[]){

  char c = 'A';
  for(c;c<='z';c++){
    if(isalpha(c))
      printf("%c %d\n",c,c);
  }

return 0;
}
