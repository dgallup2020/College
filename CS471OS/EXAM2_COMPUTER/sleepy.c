#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h>
#include<string.h>

int main(int argc, char argv[]){
int status;
char *s = NULL;
size_t bufsize;
int numread;

char *cmd1 = "sleep n - to create a process that sleeps for n seconds";
char *cmd2 = "quit    - to quit";
printf("%s\n",cmd1);
printf("%s\n\n",cmd2);

do {
	printf("sleepy> ");
	numread = getline(&s,&bufsize,stdin);	
	if(0 == strncmp(s,"sleep",4)){ // Jeff says - should be 5, not 4

		int pid = fork();
		if(pid == 0){
			char *token = strtok(s," "); //should just be sleep
			token = strtok(NULL," "); //second split
			int sleepno = atoi(token);
			if(sleepno > 60){
				printf("Setting sleepno=60, that is the max\n");
				sleepno = 60;
			}
			if(sleepno < 1){
				printf("Setting sleepno=1, that is the min\n");
				sleepno = 1;
			}
			printf("Sleeping for: %d\n",sleepno);
			sleep(sleepno);
			exit(0);
		}
		else if(pid > 0){
		  wait(&status); // Jeff says - no! if you wait, then this won't have multiple children going at the same time like my demo did.
			printf("Created Process: %d\n",pid);
		}
	}
	else if(strncmp(s,"quit",4) != 0)
		printf("Unknown Command\n");
} while(strncmp(s,"quit",4) != 0);
return 0;
}
