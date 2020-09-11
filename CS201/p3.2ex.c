#include<string.h>
#include<stdio.h>
  char *myStrrchr(const char *s, int c){
  //value returned = first address in the string  s
  //whose code is equal to c
  //or whose code is 0 if code c does not appear

while((*s!=c) && *s){
s++;
}
if(*s=='\0')
return 0;
else{


char *first = (char*)s;
char *last = 0;


for(char *i = first;*i!='\0'; i++){
//  while((*s!=c) && *s){
//  s++;
    if(*s==c){
    last = i;
    printf("%d\n",last);
    }
}
if(last==0){
printf("%d\n",first);
return first;
}
else{
printf("%d\n",last);
return last;
}
}
}
//store and continue
