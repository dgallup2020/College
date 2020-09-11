#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
int main(int argc, char*argv[]){
  int c = 0, v = 0, ch;
  while((ch=getc(stdin))!=EOF){
    if(isalpha(ch)){
      if(ch=='a'||ch=='e'||ch=='i'||ch=='u'||ch=='o')
        v++;
      else
        c++;
    }
  }
  printf("con = %d || vowels = %d\n",c,v);
}
