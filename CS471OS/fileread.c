#include<stdio.h>

int main(int argc, char*argv[]){
	printf("Input File: ");
	char input[30];
	scanf("%s",input);
	
	FILE *f = fopen(input,"r");



return 0;
}
