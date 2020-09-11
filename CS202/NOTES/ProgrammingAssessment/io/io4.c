#include<stdlib.h>
#include<stdio.h>

int main(int argc,char * argv[]){

  int c;
  int count;
  count = 0;
  
  while((c=fgetc(stdin))!=EOF)
    if(c=='x')
      count+=1;
      
  printf("count = %d\n",count);
  return 0;      
}
