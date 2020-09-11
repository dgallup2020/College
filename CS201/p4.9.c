
#include<stdio.h>

int main() {
  int n;
  int count = 0;
  while ( 1==scanf("%d", &n))
    if(n%2==0)
      count++;
  printf("%d\n", count);
}

