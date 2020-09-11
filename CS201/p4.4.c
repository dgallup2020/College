
#include<stdio.h>

int main() {
  int n;
  int ctotal = 0;
  int sum = 0;
  while ( 1==scanf("%d", &n) ){
    sum += n;
    ctotal++;
    }
  printf("%f\n", (double)sum/ctotal);
}

