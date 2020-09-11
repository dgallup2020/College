#include<stdio.h>

int main() {
  int num;
  int largest ;
  int count = 0;
  if (1==scanf("%d", &largest)) {
    while (1==scanf("%d", &num)){
       if (num>=largest) 
          largest = num;
       else
          count++;
  }
  }
  else {
    printf("No numbers in the file\n");
  }
  printf("Number of non-decreasing runs = %d\n", count);
}
