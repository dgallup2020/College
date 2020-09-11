#include<stdio.h>
#include<stdlib.h>

int main(int argc, char * argv[]){

  FILE *f_in;

  f_in = fopen(argv[1],"r");
  int c;
  
  while((c = getc(f_in))!=EOF)
    printf("%c",c);
  
  printf("\n");
  fclose(f_in);
  return 0;
}
