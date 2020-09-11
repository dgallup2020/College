#include<stdio.h>
#include<stdlib.h>
#include<string.h>


int main(int argc, char argv[]){

char string[50] = "this is a test -f -d -fu\n";
char *string2 = "BLAH BLAH BLAH\n";


printf("this : %s\n", string);

char *newarr[] = {string, NULL};
//printf("%s\n",newarr[0]); //string passes fine here



newarr[2] = NULL;
newarr[1] = (char *)malloc(strlen(string2));

strcpy(newarr[1],string2);

printf("NEXT INDEX: %s\n",newarr[1]);

//found the way to add additional strings to an undefined array of strings

// printf("final test %s\n",&newarr[2]);
return 0;
}
