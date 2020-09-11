#include<stdio.h>

int main() {
  char c;
  scanf("%d", &c);
  int i;
  for(i=128; i>0; i /=2)
    if (i&c)
       printf("1");
    else
       printf("0");
  printf("\n");
}
