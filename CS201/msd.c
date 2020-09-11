#include<stdlib.h>
#include<string.h>

char *myStrdup(const char *s) {
  //get the space for the duplicate string
  //just enough space to store the duplicate
  int cnt = 0;
  const char *s0 = s;
  while (*s++)
    cnt++;
  cnt++;
  char *extra = malloc(cnt);
  //copy the plug-in string characters into the extra space
  strcpy(extra,  s0);
  return extra;
}
