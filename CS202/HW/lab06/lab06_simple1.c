/*
  For example,
  ./s /u1/junk/kinne/shakespeare.txt
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.h"

#define MAX_WORDS 100000

word_t words[MAX_WORDS];
int numWords = 0;


// return index where s appears, or -1 if not found
int lookup_simple(char *s) {
  for(int i=0; i < numWords; i++) {
    if (strcmp(s, words[i].w) == 0) return i;
  }
  
  return -1;
}

// insert s into end of array
void insert_simple(char *s) {
  if (numWords >= MAX_WORDS) return;

  // put it at the end of the array
  init_word(&(words[numWords]));  // init
  new_word(&(words[numWords]), s);// put it there
  
  numWords++;
}

// print the words list, at most n many (-1 to print them all)
void print_simple(int n) {
  if (n < 0) n = MAX_WORDS;
  for(int i=0; i < numWords && i < n; i++) {
    print_word(&(words[i]), stdout);
  }
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

  char s[100];
  int len;
  while ((len = get_word(f, s, 100)) != -1) {
    if (len > 0) {
      int i = lookup_simple(s);
      if (i >= 0) inc_word(&(words[i]));
      else insert_simple(s);
    }
  }

  fclose(f);

  print_simple(10);
  
  return 0;
}