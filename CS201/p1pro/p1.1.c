 #include<stdio.h>

//NEW AND IMPROVED
//value plugged into n is a positive integer
//returns the  all the positive numbers from the first to the second. 
//Print the final sum
int total(int limit1,int limit2) {
  int sum = 0;
  int i;
  for(i=limit1; i<=limit2; i++) {
    sum += limit1;
    limit1++;
  }
  return sum;
}

int main() {
  printf("Please enter a small positive integer: ");
  int value1;
  scanf("%d", &value1);
  int value2;
  printf("Please enter a larger positive integer: ");
  scanf("%d", &value2);
  printf("the sum between first (%d) and second (%d) integers is %d\n", value1, value2, total(value1,value2)); 
}
