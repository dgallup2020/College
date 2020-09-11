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

  char s[1000];
  char *s2;

  while(1){
  s2 = gets(s,999);
  printf(1,"%s\n",s);
  }

  exit();
}
