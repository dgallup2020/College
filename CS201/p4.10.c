
#include<stdio.h>

int main() {
  int n;
  int count = 0;
  while ( 1==scanf("%d", &n))
    if(n%2==1 && n>10000)
      count++;
  printf("%d\n", count);
}

