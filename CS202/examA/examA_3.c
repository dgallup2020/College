/*
  Note: compile with the Makefile

  Note: correct output example

./eA3 /u1/junk/kinne/shakespeare_1000_lines.txt 
Word with maximum length has length 18 -  
swart-complexioned:        1

(Don't run it on shakespeare.txt during the exam because it is 
too slow, but FYI the longest word is 36 characters.)  
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.h"
#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/list.h"
//#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/list.c"
//#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.c"


// *** LOOK AT BOTTOM OF MAIN

 

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

  if (head == NULL) {
    printf("No words.\n");
  }
  else {

    list_node_t *ptr;  // and head declared up above

    // ****** LOOK HERE
    // examA_2 - your code should go here 
    list_node_t *largest = head;
    
    for(ptr=head; ptr != NULL; ptr=ptr->next){
      if( (ptr->data->l) > (largest->data->l))
	largest = ptr;
      //print_word(ptr->data,stdout); 
    }
    print_word(largest->data,stdout);
    printf("	length = %d\n",largest->data->l);
    
    
  }

  return 0;
}