#include<stdio.h>
#include<stdlib.h>


int main(int argc, char * argv[]){
	if(argc < 2){
		printf("Usage: memory-user MB\n");
		exit(0);
	}

	long mbSize = (atol(argv[1]) * 1024 * 1024); 
	//conversion bytes into a MB

	//printf("megabytes: %ld\n", mbSize);
	
	char temp = 1;

	char * array = malloc(mbSize);
	
	printf("main is at %p, local is at %p, buff in heap is at %p\n", main, temp, array); // should be &temp


	if(!array){
		printf("malloc failed: ending program\n");
		exit(0);
	}


	int i = 0;
	
	while(1){
		array[i++] = 1;
	}

return 0;
}