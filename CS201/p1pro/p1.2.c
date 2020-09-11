 #include<stdio.h>

//NEW AND IMPROVED
//value plugged into n is a positive integer
//returns the sum of the first n positive integers
int total(int limit) {
  int sum = 0;
  int num = 2;
//  int i;
//  for(i=0; i<limit; i+=2) {
    while(num<limit){
    sum += num;
    num+=2;
  }
  return sum;
}

int main() {
  printf("Please enter a small positive integer: ");
  int value;
  scanf("%d", &value);
  printf("the sum of the even %d integers is %d\n", value, 
  total(value)); 
}
