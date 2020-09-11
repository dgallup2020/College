#include<stdio.h>
#include<stdlib.h>

int main(int argc, char *argv[]){
  if(argc < 2){
    printf("Usage: ./a.out n\n");
    exit(0);
  }
  int val = atoi(argv[1]);
  int row;
  int col;
  int count = 0;
  for(row=1;row<=val;row++){
     for(col=0;col<row;col++)
	printf("%c",'a'+count);
     count++;
     printf("\n");
  }
    
  
  
}