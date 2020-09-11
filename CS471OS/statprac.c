#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/stat.h>
#include<sys/types.h>
#include<fcntl.h>


struct stat file;
char buf[1024];

int main(int argc, char *argv[]){
	int i = 1, t;
	while(i < argc){
		//t = stat(argv[i++],&buf);
		//printf("file?: %o\n", buf.st_mode);
		//using open rather than stat to see if a exe exists

		//for hw1e take the concate file string to fine whether this file name exists. 
		//
		//after given command from std in make a loop to check wheter the file exists if so run. 

		t = open(argv[i++],O_RDONLY);
		if(t == -1)
			printf("exe doesn't exist\n");
		else
			printf("exe does exist\n");

	}
	return 0;
}
