//get and add each number into the total; print the final total
#include<stdio.h>

int main() {
  int n;
  int total = 0;
  while ( 1==scanf("%d", &n) )
    total += n;
  printf("%d\n", total);
}

