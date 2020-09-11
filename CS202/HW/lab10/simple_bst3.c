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
  
  bst_node_t *searchwd = mk_node_bst();
  
  char search[50];
  printf("Word to look up: ");
  scanf("%s",search); //READ IN FOR THE STRING
  int i;
  for(i=0;search[i];i++){ //CONVERT STIRNG TO LOWER
    search[i] = (tolower(search[i]));
  }
  
  searchwd = lookup_bst(root,search);
  //printf("the word = %s\n",search);
  if(searchwd != NULL)
    print_word(searchwd->data,stdout);
  else
    printf("Word not found.\n");
  return 0;
}
