#include<stdio.h>
#include<stdlib.h>
#include<string.h>


int main(int argc, char argv[]){

char *string = "this is a test -f -d -fu\n";
char *string2 = "BLAH BLAH1 BLAH2\n";
char test[50] = "cry myself to sleep\n";


char *index0 = (char *)malloc(strlen(string));
memcpy(index0,string,strlen(string));

char *newarr[100] = {index0, NULL};//initialize array of strings


printf("first index: %s\n",newarr[0]); //string passes fine here


/*
newarr[2] = NULL;
newarr[1] = (char *)malloc(strlen(string2));//reassign new places, null moves to the last and the new string takes its place
memcpy(newarr[1],string2,strlen(string2)); //copy the new string into old NULL
printf("new moved string: %s\n",newarr[1]);


int g = 0;
while(g < 3)
	printf("before strtok: %s\n",newarr[g++]);
*/

//found the way to add additional strings to an undefined array of strings
//
//
//key is to put this in a function and to loop it when we are doing a strtok
//

/*
char *temp = strtok(newarr[0]," ");
while(temp != NULL){
	//printf("strtok first: %s\n",temp);
	temp = strtok(NULL," "); //this case is for the same string, its what the command wants
}
//split loop works
*/


char *temp;
temp = strtok(newarr[0]," ");
printf("first strtok value = %s\n",temp);
int i = 3;

while(temp != NULL){
	newarr[i] = NULL; //set last index as NULL
	newarr[--i] = (char *)malloc(strlen(temp)); //make space for the new string 
	memcpy(newarr[i], temp, strlen(temp));	//move the new string into the array and increment to the next null spot
	temp = strtok(NULL," ");	//make the new strtok call
	printf("new string added into the array: %s\n",newarr[i]);
	i++;
}

int g = 0;
while(g++ < 8)
	printf("final array (index %d): %s\n",g,newarr[g]);

//FINAL CONCLUSION TIL BACK, WE CANNOT GET OVER THE LIMIT OF OF THE ARRAY, OTHERWISE THEY OVERLAP

return 0;
}