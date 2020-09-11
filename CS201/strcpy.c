#include<stdio.h>

char *myStrcpy(char *dest, const char *src);  //declaration

int main() {
   char a[100];
   myStrcpy( a, "dog");
   printf("%s\n", a);
}


//definition
char *myStrcpy(char *dest, const char *src)  {
   char *d0;
   d0 = dest;
   while (*src!=0) {
      *dest = *src;
      src++;
      dest++;
   }
   *dest = *src;
   return d0;
}
