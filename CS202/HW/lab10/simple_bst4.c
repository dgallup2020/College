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
//WORKS DON'T MESS WITH!!!!!!
//one letter at a time
int doCounts(bst_node_t *root, int arry, char ch){
  if(root==NULL) return arry;
  
  arry = doCounts(root->left, arry, ch);
  //test condition
  if(ch == (*(root->data->w)))
    arry+=(root->data->count);
  
  arry = doCounts(root->right, arry, ch);
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

  int counts[26];
  int i;//initialize array everything to 0
  for(i=0;i<26;i++){
    counts[i]=0;
    //printf("%i int to %i\n",counts[i],i);
  }
  char let = 'a';  
  for(i=0;i<26;i++){
    counts[i] = doCounts(root,counts[i],let+i);
    printf("%c:      %d\n",let+i,counts[i]);
  }
 // print_bst(root, stdout);

  return 0;
}
