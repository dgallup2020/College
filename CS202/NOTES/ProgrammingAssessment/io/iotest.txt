#include<stdio.h>
#include<stdlib.h>

int main(int argc,char *argv[]){

  FILE *f_in,*f_out;
  
  
  f_in = fopen(argv[1],"r");
  f_out = fopen(argv[2],"w");
  
  int c;
  while((c=fgetc(f_in)!=EOF))
    putc(c,f_in);
    
  fclose(f_in);
  fclose(f_out);

  return 0;
}
