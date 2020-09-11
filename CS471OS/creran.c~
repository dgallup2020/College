#include<stdio.h>
#include<stdlib.h>
#include<fcntl.h>
#include<string.h>
#include<unistd.h>
#include<time.h>
//author: dylan gallup
//cs471

int main(int argc, char *argv[]){
	
	if(argc < 3){
		printf("Usage: ./creran dest size\n");
		exit(0);
	}

	char *string = "abcdefghijklmnopqrstuvwxyz";


	int dest = open(argv[1],O_WRONLY | O_CREAT | O_TRUNC | O_SYNC, S_IRWXU);
	
	int count = 0;
	do{
		write(dest,&string[rand()%26],sizeof(char));
	}
	while(++count < atoi(argv[2]));
	close(dest);
return 0;
}
