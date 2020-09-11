//two sorted files of long integers
//num6 and num7
//check which numbers in num7 are also in num6
//cost: number of comparisons this program uses


/*

       equality:  print the number; get the next value from num7;
              >:  get the next value from num7
              <:  get the next value from num6


num 6           num7



*/
#include<stdio.h>
#include<stdlib.h>

int count = 0;

int comp(long a, long b){
  count++;
  //fprintf(stderr, "%d\n", count);
  if(a==b){
    printf("%ld\n",a);
    return 1;
  }
  else if(a>b){
    return 1;
  }
  else{
    return 0;
  }
}



int main() {
long n6;
long n7;
FILE *f = fopen("num6","r"); 
FILE *g = fopen("num7","r");

long t1 = fscanf(f,"%ld",&n6);
long t2 = fscanf(g,"%ld",&n7);


while((t2==1)&&(t1==1)){
  if(comp(n6,n7)==1){
  t2=fscanf(g,"%ld",&n7);
  continue;
  }
  else{
  t1=fscanf(f,"%ld",&n6);
  continue;
  }
}
fclose(f);
fclose(g);
printf("NUMBER OF COMPARISONS = %d\n",count);
}
