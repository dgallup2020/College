#include<stdio.h>

void swap(int *p,  int *q) {
  int tmp;
  tmp = *p;
  *p = *q;
  *q = tmp;
}

int main() {
  int x= 7;
  int y = 11;
  swap(&x, &y);
  printf("%d  %d\n", x,y);
}
