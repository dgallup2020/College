#include<stdio.h>

char *myStrcat(char *dest, const char *src);  //declaration

int main() {
   char a[100] = "chicken";
   //myStrcat( a+7, "dog");
   myStrcat(a,"dog");
   printf("%s\n", a);
}


//definition
char *myStrcat(char *dest, const char *src)  {
   char *d0 = dest;
   //finding the zero in the dest string
   while (*++dest)
     ;
   
   //copy
   while ( *dest++ = *src++)
     ;
   return d0;
}
