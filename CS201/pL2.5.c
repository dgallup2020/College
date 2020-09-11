#include<stdio.h>
#include<stdlib.h>

#define SZ 65536

int c[SZ];  //initialized to 0


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

  //open the file
  FILE *f = fopen("num3", "r");
  long n;
  int count=0;
  while (1==fscanf(f, "%ld", &n)) {
     int hv =h(n);
     c[hv]++;
  }
  
  int max = 0;
  int i;
  max = c[0];
  for(i=1;i<SZ;i++){
  if(c[i]>max)
  max = c[i];
  }
  printf("Highest value in c = %d\n",max);
  //find and print the maximum value in c
  fclose(f);


}









