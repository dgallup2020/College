#include<stdio.h>
#include<stdlib.h>
#include<string.h>



struct chair {
   char name[10];
   int nLegs=1;
 };
 
 
int main(int argc,char * argv[]){
 
 struct chair chair_a[10];
 
 
 chair_a[10] = (struct chair ) malloc(sizeof(struct chair));
 
 int i = 0;
 for(i;i<10;i++){
    printf("name = %s || number of legs = %d",chair_a[i].name,chair_a[i].nLegs);
    chair_a[i].nLegs++;
 }
 
 
 
 
 
 // = "rocky";
 //printf("%s\n",chair_a->name);

   
   
}