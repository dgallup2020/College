#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main(int argc, char *argv[]) {

  /*
    Write code to read from stdin one character at a time and 
    start printing characters at the first non-white-space character
    and continue printing the characters up until the third newline
    character.

    Note that your code will keep reading as long as their input on
    stdin.  When you test your program, type ctrl-d for end of input.
   */
  
  int ch; int linecount = 0;int flag = 0;int prev = 0;
  while( (ch=fgetc(stdin))!=EOF){
    /*
  if(!flag){
    if(!isspace(ch) && isspace(prev)){
      flag = 1;  
    }
    if(ch=='\n')
	linecount++;
    continue;
  }
  */
  if(!isspace(ch)){
    flag=1;  
  }
  
  if(linecount<3 && flag)
    printf("%c",ch);
  
  
  if(ch=='\n')
    linecount++;
  }
  //prev = ch;
  
  return 0;
}