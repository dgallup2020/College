#include<stdio.h>

int main(){
  int numRows;
  int ast = 1;
  printf("enter a number");
  scanf("%d",&numRows);
  int j,k;
  for(j=0;j<numRows;numRows--){
    for(k=0;k<numRows;k++)
      printf("*");
    printf("\n");
  }
}  
