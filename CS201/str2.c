#include<stdio.h>
#include<string.h>

int myStrlen(const char *s) {
  int count = 0;
  while ( *s!=0) {
       count++;
       s++;
  }
  return count;
}

int main() {
  printf("%d\n",  strlen("John") );
  printf("%d\n",  myStrlen("John") );
}
