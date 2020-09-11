#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

// #if guard is to deal with if #include words.h from multiple different files.
//   without #if guard, compiler may have a problem with seeing these declarations
//   twice.  This makes us skip past the declarations the second time words.h
//   is included
#ifndef WORDS_H_
#define WORDS_H_

typedef struct WORD_T {
  char *w;   // space for the word
  int l;     // length of w, so we don't have to recompute
  int count; // for frequency counts
} word_t;


/* intialization */

word_t * mk_word();                  // malloc space, init

void init_word(word_t *w);           // init already malloc'ed

void new_word(word_t *w, char *s);   // put word s into w


void print_word(word_t *w, FILE *f); // print

void inc_word(word_t *w);            // inc count by 1

int get_word(FILE *f, char *s, int MAX);      // get next word in f, leave in s

#endif