#include<stdio.h>
#include<stdlib.h>
#include<string.h>



struct tcar {
   int x;
   struct tcar *next;
 };
 
 
int main(){

  struct tcar *head_node;
  head_node =  (struct tcar*) malloc(sizeof(struct tcar));
  
  head_node->x = 77;
  
  //printf("%i\n",head_node->x);
  
  struct tcar *one_node;
  one_node = (struct tcar*) malloc(sizeof(struct tcar));
  one_node->x=22;
  head_node->next=one_node;
  one_node->next=0;
  //printf("%i\n",one_node->x);
  
  //
  struct tcar *second_node;
  second_node = (struct tcar*) malloc(sizeof(struct tcar));
  second_node->x=33;
  second_node=one_node->next;
  second_node->next=0;
  struct tcar *conductor;
  conductor = (struct tcar*) malloc(sizeof(struct tcar));
  conductor=head_node;
    while(conductor->next !=0){
      conductor = conductor->next;
      printf("%i\n",conductor->x);
      }
      
 free(head_node);
 free(one_node);
 free(second_node);
 return 0;
}
