#include<stdio.h>

int myToupper(int c);

int main() {
char c;
printf("Give me a letter> ");
scanf("%c",&c);
char p = myToupper(c);
printf("%c\n",p);
}
