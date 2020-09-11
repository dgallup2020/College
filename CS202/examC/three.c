#include<stdio.h>
#include<stdlib.h>

typedef struct NODE{
   int data;
   struct NODE *next;
 } node_t;
 

int main(int argc, char*argv[]){
  node_t *head, *ptr;
  
  //answer
  char *result = "all the same";
  for(ptr = head; ptr != NULL; ptr=ptr->next){
    if((ptr->data)!=(head->data))
      result = "not all the same";
  }
  printf("%s\n",result);
  
}