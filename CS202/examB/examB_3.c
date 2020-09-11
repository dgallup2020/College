/*
  Note: compile with the Makefile.  See the comment at the end of 
        main about what your code should do.

  Note: correct output example

./eB3 /u1/junk/kinne/shakespeare_1000_lines.txt 
        outlive:        1
          aught:        1
            our:        4
    authorizing:        1
          early:        1
    outstripped:        1
        outcast:        1
       either's:        2
          eased:        1
            air:        3
          earth:        5
        earthly:        1
        outward:        2
            out:        3
            ear:        1
      out-going:        1
           each:        8
          audit:        1
            eat:        1
         either:        2
         author:        3
1.17% of the words printed.


(Don't run it on shakespeare.txt during the exam because it is 
too slow, but FYI 1.26% of the words would be printed.)  

Recall that the definition of the word_t and linked list node are - 

typedef struct WORD_T {
  char *w;   // space for the word
  int l;     // length of w, so we don't have to recompute
  int count; // for frequency counts
} word_t;

typedef struct LIST_NODE_T {
  word_t * data;
  struct LIST_NODE_T *prev, *next;
} list_node_t;

And there is a function to print a word that you can use if you want - 

void print_word(word_t *w, FILE *f); // print

 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.h"
#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/list.h"


int isvowel(int c){
 if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
   return 1;
 else
   return 0; 
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


  /*
    Your code goes here.  Note that head is already declared and points
    to the head of the linked list.

    You should iterate through the linked list to print all words that 
    are at least 2 characters long and have first 2 characters both vowels (aeiou).

    After the loop, print the percentage of words were printed.
   */
  
  int total2v = 0; int totalw = 0;
  list_node_t *ptr;
  for(ptr = head;ptr!=NULL;ptr=ptr->next){
    if((isvowel(ptr->data->w[0]))&&(isvowel(ptr->data->w[1]))&&((ptr->data->l) >= 2)){
      print_word(ptr->data, stdout); // print
      total2v+=ptr->data->count;
    }
    totalw+=ptr->data->count;
  }
  printf("%.02f percent of the words printed.\n",((double)total2v/(double)totalw)*100);
  
  
  return 0;
}