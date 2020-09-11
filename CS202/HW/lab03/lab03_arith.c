#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(int argc, char * argv[]){

  if(0==strcmp("*",argv[1])){
   // printf("congrats\n");
    
    int i;
    
    int mttotal=1;
    for(i=2;i<argc;i++)
      mttotal*=atoi(argv[i]);
  
    printf("  %d\n",mttotal);
  }
  
  
  
  
  
  if(0==strcmp("+",argv[1])){
   // printf("check"); 
    
    
    int k;
    int sum=0;
    for(k=1;k<argc;k++)
      sum+=atoi(argv[k]);
    
    printf("  %d\n",sum);
  }
  return 0;
}
/*ideas: for the recusion just make a loop to multiply all the 
arguments til the number of arguments
do the same with adding all the arguments
just add or multiply all the arguments to a sum total.
*/
