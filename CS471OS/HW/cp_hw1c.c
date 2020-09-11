// Jeff says - comments not sufficient


//okay!

#include<stdio.h>
#include<stdlib.h>
#include<fcntl.h>
#include<string.h>
#include<unistd.h>
#include<time.h>
//author: dylan gallup
//cs47103: copy program
//purpose: this program takes two files (src and dest) and copies the src in the dest
//in read and write intervals of the size of the specified buffer in the command line
//finally, the last  argument determines whether to make the file written to is
//via synchronized i/o or asynchronized i/o
int  main(int argc, char *argv[]){
	
	if(argc < 5){
		printf("Usage: ./cp_hw1c src dest bufferSize syncOrNo\n");
		exit(0);	//command line prompt if user somehow fails to type in the right arguments
	}


	
	int src = open(argv[1], O_RDONLY); //opens the src file to be read only
		if(src == -1){
			printf("Error opening file for reading\n");
			exit(0);//error statement if the file does not exist or is not a file
		}
	int dest;

	//first condition where the command line wants synchronous i/o
	if(!strcmp("O_SYNC", argv[4])){
		dest = open(argv[2],O_WRONLY | O_CREAT | O_TRUNC | O_SYNC, S_IRWXU); //opens the destination file to write only, created if it does not
											//exist, sets the file truncated to 0. and write out via synchronous
											//i/o
       			if(dest == -1) {
				printf("Error opening file for writing\n");
				exit(0);	//somehow the file writing to fails to be created. 
		}	
	}
	//second condition if the user chooses NOT want to use synchronous i/o
	else if(!strcmp("NORMAL", argv[4])){
		dest = open(argv[2],O_WRONLY | O_CREAT | O_TRUNC, S_IRWXU);// opens the dest file descriptor to write only, created if it already doesn't 
									 	//if it does exist trancated the file point to 0. 
			if(dest == -1){
				printf("Error opening file for writing\n");
				exit(0); 	//condition just in case the file trying to open fails. via memory or errors
			}
	}
	else{
		printf("please decide on syncOrNo: O_SYNC or NORMAL\n");
			exit(0);	//condition where the user does not put in either conditions for the synchronous output

	}



	ssize_t count; //variable to hold the number of characters read in by the following read call
	char *string = (char *)malloc(sizeof(unsigned char) * (atoi(argv[3]))); //setting the buffer to hold the read call
	do{
		count = read(src, string, atoi(argv[3])); //read in blocks from the source file to the string buffer
		write(dest, string, count);		//writes the blocks from the string buffer to the destination file
	}
	while(count > 0); //continues until the read sys call hits the EOF. 

	free(string); //frees the string buffer after finished with writing
	close(src);	//closes the source file
	close(dest);	//close the destination file
return 0;
}
