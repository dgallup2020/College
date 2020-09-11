/*
  For example,
  ./s /u1/junk/kinne/shakespeare.txt
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.h"
#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/list.h"
#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/hash.h"
#include "list.c"
#include "hash.c"
#include "words.c"

list_node_t *findLargest(list_node_t *head, FILE *f);

void hfindLargest(hash_table_t *T, FILE *f);
/*
 * for(int i = 0; i<t->size,i++){
 * 	list_node_t *p;
 * 	for(p=T->table[i]; p!=NULL;p=p->next)
 * 		something with p->data-w or ->count
 *}
 * 
 */




int main(int argc, char * argv[]) {

  // by default read from stdin
  FILE * f = stdin;

  // otherwise try to open a file with filename given by argv[1]
  if (argc > 1) {
    f = fopen(argv[1], "r");
    if (f == NULL) {
      fprintf(stderr, "Error opening file %s for reading.\n", argv[1]);
      exit(0);
    }
  }

  // init the hash table
  hash_table_t *T = init_hash(100000);
  
  char s[100];
  int len;
  while ((len = get_word(f, s, 100)) != -1) {
    if (len > 0) {
      list_node_t *p = lookup_hash(T, s);
      if (p != NULL) inc_word(p->data);
      else insert_hash(T, s);
    }
  }

  fclose(f);

  hfindLargest(T, stdout);

  return 0;
}


void hfindLargest(hash_table_t *T, FILE *f){
  list_node_t *largestnode = NULL;
  //change to store the largest node
  int y = 0;
    while(largestnode == NULL){
      largestnode = findLargest( (T->table)[y], f);
      y++;
    }
    
  list_node_t *newlistc;
  
  for(int i=0; i < T->size; i++){
    if( (T->table)[i] != NULL){
      newlistc = findLargest( (T->table)[i] ,f);
      if( (newlistc->data->count) > (largestnode->data->count) )
	largestnode = newlistc;
    }
  }
  printf("Word with maximum count -\n");
  print_word(largestnode->data,f);
}


list_node_t *findLargest(list_node_t *head, FILE *f){
  list_node_t *p;
  list_node_t *largest = head;// = head->next;
  
  for(p=head; p != NULL; p = p->next){
    if( (p->data->count) > (largest->data->count) ){
      //printf("check\n");
      largest = p;
      print_word(largest->data,f);
    }
    
  }
  return largest;
  //printf("Word with maximum count -\n");
  //printf("largest word: %s\n",largest->data->w);
  //print_word(largest->data, f);
}