#include<stdio.h>
#include<math.h>

int main() {

  FILE *fp = fopen("nums", "r");
  int num;
  int sum = 0;   //average
  int sumSq=0;   //average of the squares
  int count = 0;
  while ( 1==fscanf(fp, "%d", &num) )  {
     sum += num;
     sumSq += num*num;
     count++;
  }
  double mean = (double)sum/count;
  double meanSq = (double)sumSq/count;
  printf("%f %f\n", meanSq, mean*mean);
  printf("%f\n", sqrt (meanSq-mean*mean) );

}
