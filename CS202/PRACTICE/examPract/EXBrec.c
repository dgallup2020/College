#include<stdio.h>
#include<stdlib.h>

void print(int v[], int n){
  int i;
  for(int i = 0; i < n; i++) printf("%i,",v[i]);
  printf("\n");
}

void fun(int v[], int n, int i, int y[]){
  if(i==n){print(v,n); return;}
  
  int j;
  for(int j=0;j<n;j++){
    if(y[j]>0){
      v[i] = y[j]; y[j] = 0;
      fun(v,n,i+1,y);
//y\      return;
      y[j] = v[i];
    }
  }
}

int main(int argc, char*argv[]){

  int A[5],B[5] = {1,2,3,4,5};
  fun(A,3,0,B);
  return 0;

}
