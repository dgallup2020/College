#ifndef BST_H_
#define BST_H_

#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.h"

typedef struct BST_NODE_T {
  word_t * data;
  struct BST_NODE_T *left, *right;
} bst_node_t;


bst_node_t *mk_node_bst();        // allocating memory for new node, init to NULL's
//void free_node_bst(bst_node_t *p);// free memory when delete

bst_node_t *lookup_bst(bst_node_t *root, char *word); // search for word, return node

bst_node_t *insert_bst(bst_node_t **root, char *word);// create a new node, put it into the tree

//void delete_bst(bst_node_t **root, bst_node_t *p);    // remove from tree...
//void delete_bst(bst_node_t **root, char *key);

void print_bst(bst_node_t *root, FILE *f);   // print all nodes of the tree


#endif