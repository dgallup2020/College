//Dylan Gallup
//fork exam 1

#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/wait.h>

int main(int argc, char *argv[]){
	if(argc < 2){
		printf("usage: ./forks count\n");
		exit(0);
	}
	
	int n = atoi(argv[1]);
	if(n > 20)
		n = 20;
	int count = 0;
	pid_t pid;

	while(n > 0){
		printf("before loop - n: %d | process count: %d\n",n,count);
		n--; count++;
		pid = fork();
		if(pid > 0){//parent
			waitpid(0,NULL,0);
			break;		
		}	
	}
	printf("after loop - n: %d | process count: %d\n",n,count);
	return 0;
}
