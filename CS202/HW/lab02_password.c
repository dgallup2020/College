#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char * argv[]){
  
  char passwd[100];
  int i=1;

  while(i!=0){
    printf("Type a password: ");
    scanf("%99s",passwd);
    i = strcmp("fourty-two",passwd);
    if(i == 0)
      exit(0);
    //if(i==0)
    // printf("welcome\n");
  }
  return 0;
}
