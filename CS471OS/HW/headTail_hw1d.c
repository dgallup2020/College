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
//
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>


int main(int argc, char *argv[]) {
  if(argc < 2){
	printf("Usage: ./headTail_hw1d file\n");
	exit(0);
  }
	
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

  //condition where up to the first 10 lines are read 
  while ((ch = fgetc(f)) != EOF) {
    if (ch == '\n') lineNo++; //line increment counter
    if (bytes == 0){
	    prev = ch;
    	    if(!isspace(ch))	//if the first char is not a space its the first word
		    words++;
    }
    else if(!isspace(prev) && isspace(ch))//a word is defined to have a char then a space next
	    words++;
   
    if(lineNo < 10)
    	printf("%c",ch);
   
    bytes++; //each character read in is a byte
    prev = ch; //set the prev char to the current char

  }


  rewind(f); //take back to the start of file
  char *line = NULL;
  size_t len = 0;
  ssize_t nread = 0;

  int lineNo2 = 0;

//condition for file that has greater than 10 and less than eq to 20

  if(lineNo >= 10 && lineNo <= 20){ //number of line read from first file read
  	  int i = 10; //set the line number at 10
	  printf("\n ...\n");
	  while(lineNo2 < 10){
		  if('\n' == fgetc(f))//loop to get the 10th line
			lineNo2++;
	  }

	  while((i++ <= lineNo) && (nread!=-1)){ //while we have not hit the total line number keep getting lines
		nread = getline(&line,&len,f);
	       	printf("%s", line); //prints the current line
	  }
  }
	

//condidtion of a file that has greater than 20 lines. 
  if(lineNo > 20){
	lineNo2 = lineNo - 10; //limit on higher limit. 
	int i = 0;
	printf("\n ...\n");
	while(i <= lineNo2){
		if('\n' == fgetc(f))//loop to read til we hit the line 10 before the end
			i++;
	}

	while((i++ <= lineNo) && (nread != -1)){
		nread = getline(&line,&len,f); //read lines til we get to the end of the file
		printf("%s",line);
	}
  
  }
  fclose(f);
  
  printf("\n************\n");
  printf("%d	%d	%d\n",lineNo,words,bytes); //word count program total


  return 0;
}
