#include <stdio.h>
#include <stdlib.h>

#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/list.h"
#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/hash.h"

/*
  Take word and produce an index that is in the range to look inside T->table, so 0 to T->size-1
 */
int h(hash_table_t *T, char *word) {

  int total = 1; int n = T->size;
  for(int i=0; word[i] != '\0'; i++) {
    char ch = word[i];
    total = (total * ch + i) % n;
  }

  return total;
}


hash_table_t *init_hash(int initSize) {
  hash_table_t * p = (hash_table_t *) malloc(sizeof(hash_table_t));
  if (p == NULL) {
    fprintf(stderr, "Malloc failed.\n"); exit(0);
  }

  p->size = initSize;

  p->table = (list_node_t **) malloc((p->size) * sizeof(list_node_t *));
  if (p->table == NULL) {
    fprintf(stderr, "Malloc failed.\n"); exit(0);
  }

  for(int i=0; i < p->size; i++) (p->table)[i] = NULL;

  return p;
}

// search for word, return node
list_node_t *lookup_hash(hash_table_t *T, char *word) {
  int hashVal = h(T, word);

  list_node_t *p = lookup_list( (T->table)[hashVal], word);
  return p;
}

// create a new node, put it into the table
list_node_t *insert_hash(hash_table_t *T, char *word) {
  int hashVal = h(T, word);

  list_node_t *p = insert_list( &((T->table)[hashVal]), word);
  return p;
}

// print all nodes of the tree
void print_hash(hash_table_t *T, FILE *f) {
  for(int i=0; i < T->size; i++) {
    //fprintf(f," <begin slot %i\n", i);
    print_list( (T->table)[i], f);
    //fprintf(f,"    end slot %i>\n", i);
  }
}


