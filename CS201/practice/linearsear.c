#include<stdio.h>
#include<stdlib.h>
#define SZ 200000

int n[SZ];
int i;
long x;
int t1;
FILE *f = fopen("num6","r");
for(i=0;i<SZ;i++){
t1=fscanf(f,"%ld",&x);
n[i]=x;
}
fclose(f);


int main(){
for(i=0;i<SZ;i++){
printf("%ld",n[i]);
}
}
