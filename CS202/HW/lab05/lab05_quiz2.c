#include<stdlib.h>
#include<stdio.h>
#include<string.h>

int main(int argc, char *argv[]){
 
  if(argc < 2){
   printf("Usage: n1 n2 ...\n");
   exit(0);
  }
  
  
  double start = atof(argv[1]);
  //printf("%lf\n",start);
  int i;
  
  int count = 1;
  
  for(i=2;i<argc;i++){
    double cmp = atof(argv[i]);
   // printf("start = %lf || second = %lf\n",start,cmp);
    if(start != cmp)
      printf("  argv[1]-argv[%d] = %lf\n",i,start-cmp);
    else{
      count++;
     // printf("%d\n",count);
    }
  }
  //printf("count = %d\n",count);
  if(count==argc-1)
    printf("  all the same!\n");
  
}
