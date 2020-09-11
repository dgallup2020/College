#include<stdio.h>

char *myStrrchr(const char *s, int c);

int main(){
  const char *s = "this is a test";
  char c;
  printf("Please enter a character: ");
  scanf("%c", &c);
  char *p = myStrrchr(s, c);
  if (p)
    printf("index of %d\n", p-s);
}
