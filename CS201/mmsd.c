#include<stdio.h>

char *myStrdup(const char *);

int main() {
  char *d = myStrdup("cat");
  printf("%s\n", d);
}
