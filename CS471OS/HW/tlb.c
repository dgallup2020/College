/*
for those who are reading this:
author: dylan gallup
purpose: assignment hw4c, program measure the cost of how long look ups to the TLB. returns a value

*/
#include<stdio.h>
#include<stdlib.h>
#include<sys/time.h>
#include<unistd.h>

int main(int argc, char *argv[]){
	
	if(argc < 3){
		printf("Usage: ./tlb numpages trials\n");
		exit(0);
	}


	//malloc space for a array of some size??

	int numpages = atoi(argv[1]);
	int trials = atoi(argv[2]);

	int pagesize = getpagesize();
	int jump = pagesize / sizeof(int);

	int i,j;
	//making a large array for the test
	int * a = (int *)malloc(numpages * pagesize / sizeof(int));

	for(i = 0; i < numpages; i++)
		a[i] = 0;

	struct timeval start, end;
		
	double trialtime, totaltime, avetime = 0;
	//number of trials loop
	for(j = 0; j < trials; j++){
		//access loop
		//
		//need to save the time when this loop started
		totaltime = 0;
		gettimeofday(&start,NULL); //for debugging
		for(i = 0; i < numpages * jump; i += jump){
			a[i] += 1;
			//we have the difference in microseoncds
		}

		gettimeofday(&end,NULL); //for debugging
		
		trialtime = ((end.tv_usec + end.tv_sec * 1000000) - (start.tv_usec + start.tv_sec * 1000000));
		totaltime = trialtime * 1000; //convert the value into nanoseoncds
		printf("time per access in nanoseconds: %lf\n",totaltime);

	}

	free(a);
	return 0;
}
