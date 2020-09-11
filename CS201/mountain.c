#include<stdio.h>

int main() {
  int numRows;
  printf("Please enter the number of rows> ");
  scanf("%d", &numRows);
  int numAst = 1;
  int numSp = numRows-1;
  int i,j,k;
  for(i=0; i<numRows; i++) {
    for(j=0; j<numSp; j++)
      printf(" ");
    for(k=0; k<numAst; k++)
      printf("*");
    printf("\n");
    numSp--;
    numAst += 2;
  }
}
