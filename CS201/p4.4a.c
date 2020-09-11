#include<stdio.h>

int main() {
  int count = 3;
  int total = 20;
  printf("%.10e\n", total/(double)count);
  printf("%.10e\n", 1.0/3);
  printf("%.10f\n", 1.0/3);
}
