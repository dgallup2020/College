#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<sys/wait.h>
#include<unistd.h>

int main(int argc, char*argv[]){
	if(argc < 3){
		printf("usage: ./forkIt limit <loop/proc>\n");
		exit(0);
	}
	if((atoi(argv[1]) > 500) || (atoi(argv[1]) < 1)){
		printf("limit too big or too small, try between 1 and 500\n");	
		exit(0);
	}
	
	if(0==strcmp(argv[2],"loop")){
		int i = 0;
		int count = 1;
		int limit = atoi(argv[1]);
		for(i = 1; i < limit; i++)
			count++;
		printf("value of counter: %d\n",count);
	}
	else if(0==strcmp(argv[2],"proc")){
		int i = 0;
		int count = 1;
		int status;
		int limit = atoi(argv[1]);
		pid_t pid;
		while(count < limit){
			pid = fork();
			count++;
			if(pid != 0){
			waitpid(pid, &status, 0);
			break;
			}
		}
		if(count >= limit)			
			printf("value of count: %d\n",count);
	}

	else
		printf("choose either loop or proc for argv[2]\n");


	return 0;
}
