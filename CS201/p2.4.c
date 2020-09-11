#include<stdio.h>
int main(){
  int numTri;
  printf("Please enter the number of triangles> ");
  scanf("%d",&numTri);
  int numAst = 1;
  int numRows = 2;
  int i,j,k;
  for(i=0;i<numTri;i++){
    for(j=0;j<numRows;j++){
      for(k=0;k<numAst;k++)
        printf("*");
      printf("\n");
      numAst++;
    }
    numRows++;
    numAst=1;
 }
}

