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
#include "words.c"
#include "list.c"

int doCounts(list_node_t *head, int lcount, char ch){
  list_node_t *p;
  for(p=head; p != NULL; p = p->next){
    if(ch == (*(p->data->w))){
      lcount+=(p->data->count);
      //print_word(p->data,stdout);
    }
  }
  return lcount;
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

  // init the list
  list_node_t *head = NULL;
  
  char s[100];
  int len;
  while ((len = get_word(f, s, 100)) != -1) {
    if (len > 0) {
      list_node_t *p = lookup_list(head, s);
      if (p != NULL) inc_word(p->data);
      else insert_list(&head, s);
    }
  }

  fclose(f);

  //print_list(head, stdout);
  int counts[26];
  int i;
  for(i=0;i<26;i++){
    counts[i]=0;
  }
  
  char let = 'a';
  for(i=0;i<26;i++){
    counts[i] = doCounts(head,counts[i],let+i);
    printf("%c:      %d\n",let+i,counts[i]);
  }

  return 0;
}
