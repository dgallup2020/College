#include<stdio.h>
#include<stdlib.h>

int main() {
  char *extra = malloc(100);
  if (extra==0) {
     printf("Could not get the extra space");
     return 0;
  }
  //use the extra space
   
}
