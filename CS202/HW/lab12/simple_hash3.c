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

  list_node_t *search = mk_node_list();
  char sword[50];
  printf("Word to search: ");
  scanf("%s",sword);
  //printf("output %s\n",searchword);
  int i;
  for(i=0;sword[i];i++)
    sword[i] = (tolower(sword[i]));

  search = lookup_hash(T, sword);

  if(search != NULL)
    print_word(search->data,stdout);
  else
    printf("Word not found.\n");

  return 0;
}
