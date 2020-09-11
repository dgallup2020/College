#include<stdio.h>
#include<stdlib.h>

int main(int argc, char * argv[]){

  FILE *f_in;
  FILE *f_out;

  f_in = fopen(argv[1],"r");
  f_out = fopen(argv[2],"w");
  int c;
  
  while((c = getc(f_in))!=EOF)
    //printf("%c",c);
    fputc(c,f_out);
  printf("\n");
  fclose(f_in);
  fclose(f_out);
  return 0;
}
