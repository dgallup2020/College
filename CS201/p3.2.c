#include<string.h>
#include<stdio.h>
  char *myStrrchr(const char *s, int c){
  //value returned = last address in the string  s
  //whose code is equal to c
  //or whose code is 0 if code c does not appear
char *last = 0;
while((*s!='\0') && *s){
if(*s==c)
last=(char*)s;
s++;
}
if(*s=='\0')
return last;
}


