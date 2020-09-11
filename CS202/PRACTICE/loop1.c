#include <stdio.h>
#include <stdlib.h>

int main(int argc, char*argv[]){

int i = 1<<30;
for(i=1<<30; i>=1; i= i >> 1)
  printf("%d\n",i);

/*
while(i>1){
printf("%d\n",i);
i= i >> 1;
}
*/
}
