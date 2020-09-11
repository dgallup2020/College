#include<stdlib.h>
#include<stdio.h>

int main(int argc, char*argv[]){

int i, j;
for(i=1;i<=26;i++){
  for(j=0;j<i;j++)
    printf("%c",'a'+i-1);
  printf("\n");
}

}
