#include<stdio.h>

int main() {
  int num;
  int largest ;
  if (1==scanf("%d", &largest)) {
    while (1==scanf("%d", &num))
       //make variable largest contain the largest number so far
       if (num>largest) 
          largest = num;
    printf("%d\n", largest);
  }
  else {
    printf("No numbers in the file\n");
  }
}
