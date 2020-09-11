#include<stdio.h>

char *myStrchr(const char *s, int c);

int main(){
  const char *s = "this is a test";
  char c;
  printf("Please enter a character: ");
  scanf("%c", &c);
  char *p = myStrchr(s, c);
  if (p)
    printf("index of %d\n", p-s);
}
