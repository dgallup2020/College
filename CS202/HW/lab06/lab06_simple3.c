
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

void free_simple() {
  for(int i=0; i < numWords; i++) {
    free_string_word(&(words[i]));
  }
  numWords = 0;
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

  
  
  //loop
  //int sss = 0;
  //for(sss=0;sss<numWords;sss++)
  //printf("%8s    %4i\n",words[sss].w,words[sss].count);
  
  int ttt = 0;
  int totalc = 0;
  
  for(ttt=0;ttt<numWords;ttt++)
    totalc += words[ttt].count;  
    
  if(totalc == 0){
      printf("No words in input.\n");
      fclose(f);
      free_simple();
      return 0;
  }
  
  int smallc = words[0].count;
  int highc = words[0].count;
  int sss;
  
  
  for(sss=0;sss<numWords;sss++){
    
    if(smallc > words[sss].count)
      smallc = words[sss].count;
    
    if(words[sss].count > highc)
      highc = words[sss].count;
  }
  //numWords is the number of different words
  
  
  double totalc2 = (double)totalc;
  double numWords2 = (double)numWords;
  double ave = totalc2/numWords2;
  
  
  
  
  
  
  printf("Min count:             %d\n",smallc);
  printf("Max count:             %d\n",highc);
  printf("Total different words: %d\n",numWords);
  printf("Total count:           %d\n",totalc);
  printf("Average count:         %.2lf\n",ave);
  
  printf("\n");
  
  char SearchWord[100];
  printf("Word to lookup:        ");
  scanf("%99s",SearchWord);
  //printf("%s\n",SearchWord);
  
  
  int flag1 = 0;
  int wordIndex;
  
  int uuu=0;
  for(uuu=0;uuu<numWords;uuu++){
    if(strcmp(words[uuu].w,SearchWord)==0){
	    flag1 = 1;
      wordIndex = uuu;
    	break;
    	}
  }
  //CHECKING LOOP TO SEE DATA STORE
  
  //printf("%s\n",SearchWord);
  if (flag1==1)
    printf("Count for %s:         %d\n",SearchWord,words[wordIndex].count);
    //printf("%s  count:   %d\n",words[wordIndex].w,words[wordIndex].count);
  else
    printf("not found\n");
  
  
  
  fclose(f);
  free_simple();
  
  return 0;
}
