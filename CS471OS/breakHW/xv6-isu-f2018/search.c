#include "types.h"
#include "stat.h"
#include "user.h"

int
main(int argc, char *argv[])
{
  if(argc < 2){
    printf(2, "Usage: string\n");
    exit();
  }

  char s[100];
  char *s2;
  int count = 0;

  while(1){
    s2 = gets(s,100);
    if(s2[strlen(s2)-1] == '\n')
    	s2[strlen(s2)-1] = '\0';
    if(0==strcmp(s2,argv[1]))
	    count++;
    //if(0==strcmp(s2,"stop"))
    //	    break;
  }
  printf(1,"count: %d\n",count);

  exit();
}
