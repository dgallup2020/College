 #include<stdio.h>

//NEW AND IMPROVED
//value plugged into n is a positive integer
//returns the sum of the first n positive integers
int total(int limit) {
  int sum = 0;
  int num = 1;
  int i;
  for(i=0; i<limit; i++) {
    sum += num;
    num++;
  }
  return sum;
}

int main() {
  printf("Please enter a small positive integer: ");
  int value;
  scanf("%d", &value);
  printf("the sum of the first %d integers is %d\n", value, total(value)); 
}
