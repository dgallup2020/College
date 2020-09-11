#ifndef LIST_H_
#define LIST_H_

#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.h"

typedef struct LIST_NODE_T {
  word_t * data;
  struct LIST_NODE_T *prev, *next;
} list_node_t;


list_node_t *mk_node_list();        // allocating memory for new node, init to NULL's
//void free_node_list(list_node_t *p);// free memory when delete

list_node_t *lookup_list(list_node_t *head, char *word); // search for word, return node

list_node_t *insert_list(list_node_t **head, char *word);// create a new node, put it into the list

//void delete_list(list_node_t **head, list_node_t *p);    // remove from list...
//void delete_list(list_node_t **head, char *key);

void print_list(list_node_t *head, FILE *f);   // print all nodes of the list


#endif