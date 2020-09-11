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

//compare the first letter in each node to the character input
int doCounts(hash_table_t *T, char letter);

int listCounts(list_node_t *head, char ch);

struct alpha_array {
  char letter;
  int count; 
};


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

  struct alpha_array counts[256]; //initialize the array
  int i; 
  for(i = 0; i < 256; i++){
    counts[i].letter = i;
    counts[i].count = 0;
    //printf("letter: %c || counts: %d\n",counts[i].letter,counts[i].count);
  }
    
  
  
  //print_hash(T, stdout);
  for(i = 0; i < 256; i++){
    counts[i].count = doCounts(T,counts[i].letter);
    if(islower(counts[i].letter))
      printf("%c:      %d\n", counts[i].letter, counts[i].count);
    //print counts of words //is alpha
  }

  return 0;
}


int doCounts(hash_table_t *T, char let){
  int counts = 0; int j;
  for(int j = 0; j < T->size; j++){
    if( (T->table[j]) != NULL )
      counts += listCounts((T->table)[j], let);
  }
  return counts;
}
/*

void print_hash(hash_table_t *T, FILE *f) {
  for(int i=0; i < T->size; i++) {
    //fprintf(f," <begin slot %i\n", i);
    ( (T->table)[i], f);
    //fprintf(f,"    end slot %i>\n", i);
  }
}

void print_list(list_node_t *head, FILE *f) {
  list_node_t *p;
  
  for(p=head; p != NULL; p = p->next) {
    // print p
    print_word(p->data, f);
  }
}
*/
int listCounts(list_node_t *head, char ch){
  int lcount = 0;
  list_node_t *p;
  for(p=head; p != NULL; p = p->next){
    if('\0' != (*(p->data->w+1)))
      if(ch == (*(p->data->w+1))){
        lcount+=(p->data->count);
    }
  }
  return lcount;
}



