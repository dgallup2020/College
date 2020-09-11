#include<stdio.h>
int main(){
  int numTri;
  printf("Please enter the number of triangles> ");
  scanf("%d",&numTri);
  int numSpa = (numTri*2) + 1;
  int numRows = numTri + 1;
  int numBuf = numTri;
  int numAst = 1;
  int i,j,k;
  for(i=0;i<numRows;i++){
  //possible another loop for * ** ***
    for(j=0;j< numSpa;j++)
    printf(" ");
    for(k=0;k<numAst;k++)
    printf("*");
    printf("\n");
  }
}
  
