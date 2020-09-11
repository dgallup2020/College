#include<stdio.h>
#include<stdlib.h>


int main(int argc, char*argv[]){
	FILE *f;
	f = fopen(argv[1],"r");
	if(f == NULL)
		exit(0);
	else
		f = stdin;

	size_t len = 0;
	char *line = NULL;


	while(getline(&line,&len,f) != -1){
		printf("line read: %s\n",line); 
	}
	



return 0;
}
