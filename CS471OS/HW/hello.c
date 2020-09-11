#include<stdio.h>
#include<stdlib.h>
#include<fcntl.h>
#include<string.h>
#include<unistd.h>
#include<time.h>
//author: dylan gallup
//cs471

int main(int argc, char *argv[]){
	
	if(argc < 5){
		printf("Usage: ./cp_hw1c src dest bufferSize syncOrNo\n");
		exit(0);
	}

	int compv;

	
	int src = open(argv[1], O_RDONLY);
		if(src == -1){
			printf("Error opening file for reading\n");
			exit(0);
		}
	int dest;
	//seg fault after
	if(0 == (compv = strcmp("O_SYNC", argv[4]))){
		dest = open(argv[2],O_WRONLY | O_CREAT | O_TRUNC | O_SYNC, S_IRWXU);
       			if(dest == -1) {
				printf("Error opening file for writing\n");
				exit(0);
		}	
	}
	else if(0 == (compv = strcmp("NORMAL", argv[4]))){
		dest = open(argv[2],O_WRONLY | O_CREAT | O_TRUNC, S_IRWXU);
			if(dest == -1){
				printf("Error opening file for writing\n");
				exit(0);
			}
	}
	else{
		printf("please decide on syncOrNo: O_SYNC or NORMAL\n");
			exit(0);

	}



	//what is wrong with this loop
	ssize_t count;
	//buffer
	char *string = (char *)malloc(sizeof(unsigned char) * (atoi(argv[3])));
	do{
		//bytes = read(int fd, void *buf, size_t count)
		count = read(src, string, atoi(argv[3]));
		printf("count = %d\n", count);
		write(dest, string, count);
	}
	while(count > 0);//while not EOF

	free(string);
	close(src);
	close(dest);
return 0;
}
