#include<stdio.h>

int main() {
  int freq[26];
  int i;
  for(i=0; i<26; i++) // sets all the indexes for each letter 
    freq[i] =0; //and sets them to start a count of 0
  char c;
  while(1==scanf("%c", &c)) { // takes each letter
     if (c>='A' && c<='Z') { //substracts char codes to place a count 
       freq[c-'A']++; // on a letter
     }
     if (c>='a' && c<='z') {
       freq[c-'a']++;
     }
  }
  printf("\n");
  for(i=0; i<26; i++)
    printf("%c %d\n", 'A' +i, freq[i]); //prints the letters counts
}
