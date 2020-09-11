#include<string.h>
#include<stdlib.h>

char *myStrdup(const char *s) {
   int sz = strlen(s);  //number of char's (not include the 0)
   char *target = (char *) malloc(sz+1);
                //cast: changing type (void *) to (char *)
   strcpy(target, s);
   return target;
}
