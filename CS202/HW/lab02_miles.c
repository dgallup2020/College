#include<stdio.h>
#include<stdlib.h>
//multiply the ratio of 1 mile to whatever10: parsecs, light years, light minutes, light seconds, leagues, km, m, yd, in, cm.
int main(int argc, const char * argv[]){
  double a;
  printf("How many miles? ");
  scanf("%lf",&a);
  //printf("%lf\n",a);
  double b[11] = 
  {1.917E+13,5.879E+12,1.118E7,186282,3.45234,0.621371,0.000621371,0.000568182,1.57828E-5,6.21371e-6};
  //values are all checked
  const char *val[11];
  val[0] = "parsecs";
  val[1] = "light years";
  val[2] = "light minutes";
  val[3] = "light seconds";
  val[4] = "leagues";
  val[5] = "km";
  val[6] = "m";
  val[7] = "yd";
  val[8] = "in"; 
  val[9] = "cm";
  
  int i;
  for(i=0;i<10;i++)
  //  printf("%lf\n",b[i]);
  // printf("%s\n",val[i]);
  printf(" = %lf %s\n", a/b[i], val[i]);
return 0;
}
