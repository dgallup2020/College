/*
  For example,
  ./s /u1/junk/kinne/shakespeare.txt
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.h"
#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/bst.h"
#include "words.c"
#include "bst.c"

//find and print the word with the highest count, in case of ties, 
//output the alphabetically smaller one. 


// need some way to save and return the smallest alphabetical
bst_node_t *findLargest(bst_node_t *root, bst_node_t *temp, FILE *f) {

  if (root == NULL) return temp;
  // check everything to the left.
  temp = findLargest(root->left, temp, f);
  // store the highest.
  if((root->data->count) >= (temp->data->count)){
    if(strcmp(root->data->w,temp->data->w) < 0) 
      temp=root;
  }
  
  // check everything to the right.
  temp =  findLargest(root->right, temp, f);
}





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

  // init the BST!
  bst_node_t *root = NULL;
  
  char s[100];
  int len;
  while ((len = get_word(f, s, 100)) != -1) {
    if (len > 0) {
      bst_node_t *p = lookup_bst(root, s);
      if (p != NULL) inc_word(p->data);
      else insert_bst(&root, s);
    }
  }


  fclose(f);

  bst_node_t *temp = mk_node_bst();
  temp = root;
  temp = findLargest(root,temp,stdout);
  printf("Word with maximum count -\n");
  print_word(temp->data,stdout);
  


  return 0;
}

