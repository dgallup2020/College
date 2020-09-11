#include<stdio.h>
int main(){
  int numRows;
  printf("Please enter the number of rows> ");
  scanf("%d",&numRows);
  int numAst = 1;
  int i,j;
  for(i=0;i<numRows;i++){
    for(j=0;j<numAst;j++)
      printf("*");
    printf("\n");
    numAst++;
  }
}

