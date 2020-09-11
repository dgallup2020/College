#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

//char s[10] = "hello";
//PART 1 logic all finished just need to fix print out
/*
  Part 2 - To do: rename this function cipher, add an integer parameter that is the amount
         to shift the letters by (1 would shift a to be b, b to be c, etc.; and -1
	 would revese that)
 */
void cipher(char *s, int shift) {
  if (!*s) return;

  // Part 2 - only do this if isalpha(*s), and do the following
  //          *s = toupper(*s), then set *s to be (*s + n - 'A' + 26) % 26 + 'A'
  if(isalpha(*s)){
    *s = toupper(*s);
    *s = (*s + shift - 'A' + 26) % 26 + 'A';
  }
  //(*s)++;
  //printf("%s",s);
  cipher(s+1, shift);
}

int main(int argc, char *argv[]) {

  /*
    Part 1 - To do: ask the user to type a string, store it.
   */
   printf("Type a string: ");
   char phrase[100];
   scanf("%s",phrase);

  /*
    Part 1 - To do: ask user if they want to encode or decode.  Assume they
           type e or d.  If they type neither then ask again.
   */
  int ck;
  do{
  printf("Encode or decode (e or d): ");
  char code[50];
  scanf("%s",code);

  if(strcmp("e",code)==0){
    ck=1;
    //printf("encode\n");
    }
  if(strcmp("d",code)==0){
    ck=2;
    //printf("decode\n");
    }

  } while(ck!=1 && ck!=2);  
  
  
  /*
    Part 1 - To do: ask the user for an integer amount to shift by, between 0 and 26.
           if they type something outside of that range, ask again.
	   Store the amount of shift in a variable n.
   */
  int n;
  int ck2=0;
  do{
  printf("Shift amount (0-26): ");
  scanf("%d",&n);
  if((n>=0) && (n<=26))
    ck2=1;
  }while(ck2==0);
  /*
    Part 2 - To do: if they typed encode, then call cipher(yourString, n)
   */
  if(ck==1)
    cipher(phrase,n);
  /*
    Part 2 - To do: if they typed decode, then call cipher(yourString, -n)
   */
  if(ck==2)
    cipher(phrase,-n);
  /*
    Part 2 - To do: print the result
   */
  printf("%s\n",phrase);

  /* 
     Code that was in the file from the quiz, commented out so you can
     still look at it if you want, but you won't use it for the HW.

  int i;
  for(i=0; s[i] != '\0'; i++) {
    printf("%c-", s[i]);
  }
  printf("\n");

  fun(s);
  printf("%s\n", s);
  */  
  
  return 0;
}
