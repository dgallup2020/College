#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.h"

// initialize w
void init_word(word_t *w) {
  if (w == NULL) return;

  //(*w).count = 0
  w->count = 0;
  w->l = 0;
  w->w = NULL;
}

// allocate new w and return
word_t * mk_word() {
  // malloc memory
  word_t * w = (word_t *) malloc(sizeof(word_t));
  if (w == NULL) {
    fprintf(stderr, "Error in malloc in mk_word.\n");
    exit(0);
  }

  // initialize and return
  init_word(w);
  return w;
}

// print it
void print_word(word_t *w, FILE *f) {
  fprintf(f, "%15s: %8i\n", w->w, w->count);
}

// just increase the count
void inc_word(word_t *w) {
  w->count++;
}

// w is already allocated, now put s into it.
void new_word(word_t *w, char *s) {
  // just in case
  if (w == NULL) return;
  if (w->w != NULL) free(w->w);

  w->l = strlen(s);
  w->w = (char *) malloc(sizeof(char) * (w->l+1));
  if (w->w == NULL) {
    fprintf(stderr, "Error with malloc in new_word.\n");
    exit(0);
  }
  strcpy(w->w, s);

  w->count = 1;
}

// return length returned, -1 if fail/eof
// store into s, should not store more than MAX characters
// for breaking words, rule is: word must begin with alpha, must end with alpha,
//  can have - and '.  convert all letters to alpha.
int get_word(FILE *f, char *s, int MAX) { 
  s[0] = '\0';
  
  int len = 0;
  int ch;
  int count = 0;
  while ((ch = fgetc(f)) != EOF) {
    count++;

    // word termination - whitespace, leading non-alpha, punct that is not ' or _
    if (isspace(ch) ||
	(len == 0 && (! isalpha(ch))) ||
	(ispunct(ch) && ch != '-' && ch != '\'')) 
      break;

    // not word termination, so store it.
    if (len+1 < MAX) {
      s[len] = tolower(ch);
      len++;
      s[len] = '\0';
    }
  }

  if (count == 0) return -1;

  return len;
}