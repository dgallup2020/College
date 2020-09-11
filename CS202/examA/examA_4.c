/*
  Note: compile with the Makefile

  Note: correct output example

./eA4 /u1/junk/shakespeare.txt 
Height of tree: 37

./eA4 /u1/junk/kinne/shakespeare_1000_lines.txt 
Height of tree: 25
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.h"
#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/bst.h"


// *******  LOOK HERE
// examA, you to do - create a height function here.  Note that it is called in main.
// you just have to create the right height function here.



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

  int h = height(root);
  printf("Height of tree: %i\n", h);

  return 0;
}