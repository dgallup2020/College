#include<stdio.h>
//0-9 frequencies final results should be printed out
int main() {
  int freq[10];
  int i;
  for(i=0; i<10; i++) // sets all the indexes for each letter 
    freq[i] =0; //and sets them to start a count of 0
  char c;
  while(1==scanf("%c", &c)) { // takes each letter
     if (c>='0' && c<='9') { //substracts char codes to place a count 
       freq[c-'0']++; // on a number
  }
  }
  printf("\n");
  for(i=0; i<10; i++)
    printf("%c %d\n", '0' +i, freq[i]); //prints the letters counts
}
