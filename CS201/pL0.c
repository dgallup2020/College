#include<stdio.h>

#define SZ 65536


int h(long n) {
  long mask = 0xFFFF;
  int quarter1 =  n&mask;
  long n1 =   n>>16;
  int quarter2 = n1&mask;
  long n2 = n1>>16;
  int quarter3 = n2&mask;
  long n3 = n2>>16;
  int quarter4 = n3&mask;
  return quarter1^quarter2^quarter3^quarter4;
}

int main() {
  long n;
  while (1==scanf("%ld", &n)) {
     int hv =h(n);
     if (hv<0 || hv>65535)
       printf("Error\n");
  }
  
}









