#include<string.h>
  char *myStrchr(const char *s, int c){
  //value returned = first address in the string  s
  //whose code is equal to c
  //or whose code is 0 if code c does not appear

while((*s!=c) && *s){
s++;
}
if(*s==0)
return 0;
else
return (char *)s;
}
