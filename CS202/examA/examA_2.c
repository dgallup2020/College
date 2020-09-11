#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main(int argc, char *argv[]) {

  // you to do: read characters from stdin,
  //  print alpha characters as upper case,
  //  print '!' in place of '.',
  //  print all other characters as they are
  
  FILE *f;
  /*
  if(argc > 1){
    f = fopen(argv[1], "r");
    if(f == NULL){
      fprintf(stderr, "Error opening file %s for reading \n",argv[1]);
      exit(0);
    }
  }
  else
  */  
  f = stdin;

  int ch = 0;
  while((ch = fgetc(f)) != EOF){
    if(isalpha(ch))
      ch = toupper(ch);
    
    if(ch == '!')
	ch = '.';
    
    
    printf("%c",ch);
  }
  
  
  fclose(f);
  
  return 0;
}