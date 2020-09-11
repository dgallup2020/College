/*
  Author:   Dylan Gallup
  Date:     September 1, 2018
  Contents: prints first 10 lines from either a file or stdin.
            Practice using file streams.
 */

//we have 3 conditions
//1. lines <= 10; just print the first up to 10   (achieved)
//2. lines >= 20; print the first 10 and last 10. kinda tricky
//3. 10 < lines < 20 print the first 10, but as many lines you can get after. with a split after 10
//(achieved)

// useful functions he said would be strtok and getline
//similar to wc: lines, words, bytes
//creation of a array of strings to hold the last ten lines?
//
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>


int main(int argc, char *argv[]) {
  FILE * f;
  if (argc > 1) { // if like ./head471 cp.
    f = fopen(argv[1], "r");
    if (f == NULL) {
      fprintf(stderr, "Error opening file %s\n", argv[1]);
      exit(0);
    }
  }
  else
    f = stdin;

  int ch;
  int prev;
  int lineNo = 0;
  int words = 0;
  int bytes = 0;
  while ((ch = fgetc(f)) != EOF) {
    if (ch == '\n') lineNo++;
    if (bytes == 0){
	    prev = ch;
    	    if(!isspace(ch))
		    words++;
    }
    else if(!isspace(prev) && isspace(ch))
	    words++;
   
    if(lineNo < 10)
    	printf("%c",ch);
   
    bytes++;
    prev = ch;

  }


  rewind(f); //take back to the start of file
  char *line = NULL;
  size_t len = 0;
  ssize_t nread = 0;

  int lineNo2 = 0;

//condition for file that has greater than 10 and less than eq to 20

  if(lineNo >= 10 && lineNo <= 20){
  	  int i = 10;
	  printf("\n ...\n");
	  while(lineNo2 < 10){
		  if('\n' == fgetc(f))
			lineNo2++;
	  }

	  while((i++ <= lineNo) && (nread!=-1)){
		nread = getline(&line,&len,f);
	       	printf("%s", line);
	  }
  }
	

//condidtion of a file that has greater than 20 lines. 
  if(lineNo > 20){
	lineNo2 = lineNo - 10; //limit on higher limit. 

  
  }
  fclose(f);
  
  printf("\n************\n");
  printf("%d	%d	%d\n",lineNo,words,bytes);


  return 0;
}
