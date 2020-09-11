#include<stdio.h>

char *myStrcpy(char *dest, const char *src);  //declaration

int main() {
   char a[100];
   myStrcpy( a, "dog");
   printf("%s\n", a);
}


//definition
char *myStrcpy(char *dest, const char *src)  {
//   char *d0;
//   d0 = dest;
   char *d0 = dest;             //this is legal
   while (*dest++ = *src++)
     ;
//   *d0 = dest;   //this is illegal
   return d0;
}
