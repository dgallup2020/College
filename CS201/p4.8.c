#include<stdio.h>
#include<math.h>

int main() {

  FILE *fp = fopen("nums", "r");
  int num;
  int sum = 0;
  int count = 0;
  while ( 1==fscanf(fp, "%d", &num) )  {
     sum += num;
     count++;
  }
  double mean = (double)sum/count;
  fclose(fp);
  fp = fopen("nums", "r");
  double sumf = 0;
  while ( 1==fscanf(fp, "%d", &num) )  {
    sumf  += (num-mean)*(num-mean);
  }
  printf("%f\n", sqrt(sumf/count));


}
