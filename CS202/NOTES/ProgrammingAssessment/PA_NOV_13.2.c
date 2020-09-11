#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
 int lcount = 3; int ch;
 while((ch = fgetc(stdin))!=EOF){
   if(ch=='\n')
     lcount++;
   if(lcount%3!=0)
     continue;
   printf("%c",ch);
   if(lcount%3==1)
     printf("\n");
   
 }
 return 0;
  
}