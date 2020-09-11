#include<stdio.h>

int myStrcmp(const char *s1,  const char *s2);

int main() {
  printf("%d\n", myStrcmp("cat", "cats") );
  printf("%d\n", myStrcmp("cats", "cat"));
  printf("%d\n", myStrcmp("cat", "cat"));
  printf("%d\n", myStrcmp("dog", "cat"));
}

