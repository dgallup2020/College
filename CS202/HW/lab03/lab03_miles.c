#include<stdio.h>
#include<stdlib.h>


int main(int argc,char * argv[]){
  
  if(argc < 2){
    printf("Usage: ./a.out num\n");
    exit(0);
  }
  
  double a = atof(argv[1]);
  //double a = (double)(atoi(argv[1]));
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


