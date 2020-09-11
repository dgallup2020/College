#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

int main(int argc,char*argv[]){

  if(argc<2){
    printf("Usage: string\n");
    exit(0);
  }
  int strleng = strlen(argv[1]);
  //printf("%d\n",strleng);
  
  
  int i;
  char flagup[10] = "yes";
  
  char ucflag[10];
  strcpy(ucflag,"no");
  //printf("%s\n",ucflag);
  char lcflag[10];
  strcpy(lcflag,"no");
  //printf("%s\n",lcflag);
  char dgflag[10];
  strcpy(dgflag,"no");
  //printf("%s\n",dgflag);
  char pnflag[10];
  strcpy(pnflag,"no");
  //printf("%s\n",pnflag);
  

  for(i=0;i<strleng;i++){
    //printf("%c\n",argv[1][i]);
    if(isupper(argv[1][i]))
      strcpy(ucflag,flagup);
    if(islower(argv[1][i]))
      strcpy(lcflag,flagup);
    if(isdigit(argv[1][i]))
      strcpy(dgflag,flagup);
    if(ispunct(argv[1][i]))
      strcpy(pnflag,flagup);
      
  }
  
  printf("length: %d\n",strleng);
  printf("upper:  %s\n",ucflag);
  printf("lower:  %s\n",lcflag);
  printf("digit:  %s\n",dgflag);
  printf("punct:  %s\n",pnflag);
  
  
  return 0;
  
  
  
}
/*loop through all the characters and do the test.
 */