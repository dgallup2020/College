/*
  Note: compile with the Makefile

  Note: correct output example

./eB4 /u1/junk/shakespeare.txt 
Number of words with ... 
  1 letter: 20
  2-5 letters: 5916
  20-100 letters: 12

./eB4 /u1/junk/kinne/shakespeare_1000_lines.txt 
Number of words with ... 
  1 letter: 6
  2-5 letters: 785
  20-100 letters: 0


Recall that the definition of the word_t and bst node are - 

typedef struct WORD_T {
  char *w;   // space for the word
  int l;     // length of w, so we don't have to recompute
  int count; // for frequency counts
} word_t;

typedef struct BST_NODE_T {
  word_t * data;
  struct BST_NODE_T *left, *right;
} bst_node_t;

 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.h"
#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/bst.h"


// examB, you to do - create a count function here.
// The function should have two parameters and return the
// number of nodes in the tree that are words with length
// between the two parameters

int count(int x, int y){
 if() return NULL;



 
  
  
  
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

  // examB - leave this alone, this calls the count
  //  function you should put above main.
  printf("Number of words with ... \n");
  printf("  1 letter: %d\n", count(root,1,1));
  printf("  2-5 letters: %d\n", count(root,2,5));
  printf("  20-100 letters: %d\n", count(root, 20, 100));


  return 0;
}