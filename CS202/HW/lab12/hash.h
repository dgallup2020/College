#ifndef HASH_H_
#define HASH_H_

#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.h"
#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/list.h"

typedef struct HASH_TABLE_T {
  list_node_t **table;    // array, table T
  int size;              // maximum index-1 
} hash_table_t;


int h(hash_table_t *T, char *word); // hash function

hash_table_t *init_hash(int initSize);          // initialize empty hash table

list_node_t *lookup_hash(hash_table_t *T, char *word); // search for word, return node

list_node_t *insert_hash(hash_table_t *T, char *word);// create a new node, put it into the table

//void delete_hash(hash_table_t **T, char *key);

void print_hash(hash_table_t *T, FILE *f);   // print all nodes of the tree


#endif