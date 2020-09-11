/*
  Edited by:   Dylan Gallup
  Date:     September 6, 2018
  Contents: program to read a command from the keyboard and execute it.
            

  	homework on how to use processes (fork, execve, wait)

//3 goals:
//	1. if there is a command line argument prepend this command when trying to run. So the program could have an arg list of ./run_hw1e /bin/
//	----------achieved++
//
//	2. before the call to execve, properly parse the command into teh program name to run and the arguments. 
//	seems like the best idea for this is take all the arguments from commnd array, and strok the array with a space as the token and split the arguments apart
//	-------------achieved++
//	3. if there is more than one command-line argument then treat them as a sequence of paths to try looking for the program to run in execve
	use a loop to concate the full command, then check with open 

//Kinne's notes on the run program

	    Note that execve never returns if it is successfull!
	    But what if want it to return?  We fork, create two copies
	    of our program; one of the copies of the program does execve;
	    the other copy of the program waits for it to finish.
 */
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <sys/wait.h>

int main(int argc, char * argv[]) {


	if(argc < 1){
		printf("Usage: (path) arguments\n");
		exit(0);
	}

  char command[100];
  int len;


  char *cmdpath = malloc(sizeof(char)*strlen(argv[1]));
  strcpy(cmdpath,argv[1]);
	//printf("new cmd path %s\n",cmdpath); creation of the new string is good


  do {
    len = 0; command[len] = '\0';
    printf("> ");

    int ch;
    while ((ch = getchar()) != EOF && ch != '\n') {
      if (len < 100) { command[len++] = ch; command[len] = '\0'; }
    } //string to hold the command

    if (ch == EOF) break;

    if (strcmp(command, "quit") == 0) break; //if the user types quit the program ends
    
    pid_t p = fork(); // create two nearly identical copies of the program
    
	

    if (p == -1) {
      fprintf(stderr, "Unable to fork.\n"); //error on fork
    }



    else if (p == 0) { // CHILD, execute the command
      
	char * newenviron[] = { NULL };



	cmdpath = realloc(cmdpath,(sizeof(char)*(strlen(cmdpath)+strlen(command))+1));
	strcat(cmdpath,command);
	printf("newstring == %s\n",cmdpath); //string concate of argv and command is good
	//cmdpath holds the new argument list
	
      char * newargv[100] = { cmdpath, NULL }; // if wanted arguments to be /bin/ls -l -hello, //string holds 100 different arguments
                                            // char * newargv[] = {"/bin/ls", "-l", "-hello", NULL}; this can be achieved throught strtok with a space tok
					    // we are moving the null argument down one, and then put the string where the arg was. we can malloc space
					    // to hold the string in the array of pointers. part 2 of assignment

      char * tokstring = cmdpath;
      char * token;
      token = strtok(tokstring," ");
      int i = 0; //array index
      while(token != NULL){	//parses into the newargv array all the arguments
	      //printf("current token(%d): %s\n", i, token);
	      newargv[i+1] = NULL;
	      newargv[i++] = token;
	      token = strtok(NULL," ");
      }
	

					    //
      int ret = execve(cmdpath, newargv, newenviron);
      if (ret == -1) fprintf(stderr, "Error on execve\n"); //this shouldn't even run
      exit(0);
    }


    else if (p > 0) { // parent, wait for the child
      int wstatus;
      int ret = waitpid(p, &wstatus, 0);
      if (ret == -1) fprintf(stderr, "Error on waitpid\n");
    }
    
  } while (strcmp(command,"quit") != 0);

  free(cmdpath);

  return 0;
}
