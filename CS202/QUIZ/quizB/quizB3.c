#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>


int main(int argc,char *argv[]){
  
 FILE *f;
  
 if(argc > 1){
   f = fopen(argv[1], "r");
   if(f == NULL){
      fprintf(stderr, "Error opening file %s for reading \n",argv[1]);
      exit(0);
   }
 }
 
 int ch = 0;
 
 int alpha = 0;
 int ws = 0;
 int punct = 0;
 int digit = 0;
 int count = 0;
 
 while((ch = fgetc(f)) != EOF){
  count++;
  if(isalpha(ch))  
    alpha++;
  if(isspace(ch))
    ws++;
  if(ispunct(ch))
    punct++;
  if(isdigit(ch))
    digit++;  
 }
 
 
 
 //printf("count = %d\n",count);
 //printf("alpacount = %d\n",alpha);
 
 printf("alpha:       %.0f%\n",alpha/count);
 printf("whitespace:  %.0f%\n",ws/count);
 printf("punct:       %.0f%\n",punct/count);
 printf("digit:       %.0f%\n",digit/count);
 
 
 
 fclose(f);
  return 0;
}