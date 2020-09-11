#include<stdio.h>
#include<sys/times.h>
#include<unistd.h>
#define R  200000
long a[R];

//i is the index of the "bad" node
//n is the number of items in the array
void swapDown(int i, int n) {
  int left = 2*i;
  if (left>n) return;
  int bigPos = left;
  if (2*i+1<=n && a[2*i+1]>a[left])
    bigPos = 2*i+1;
  //so bigPos is the index of the biggest child

  if (a[i]<a[bigPos]) {
    long tmp = a[i];
    a[i] = a[bigPos];
    a[bigPos] = tmp;
    swapDown(bigPos, n);
  }
}



// uses maxPos to sort the array
int main() {
  struct tms buf;
  long tics = sysconf(_SC_CLK_TCK);
  int end; //index of the last item
  //fill 0..end positions with integers from a file
  int i=1;
  while (1==scanf("%ld", a+i))
    i++;
  //
  int n = i-1;

   //sort the array
  long sec0=times(&buf);
  //build the max heap
  for(i=n/2; i>0; i--)    //index is the place that might be bad
    swapDown(i,n);
  //use heap to do the sort
  int n0 = n;
  while(n>1) {
    long tmp = a[1];
    a[1] = a[n];
    a[n] = tmp;
    n--;
    swapDown(1,n);
  }
 // printf("%f\n", (double)(times(&buf)-sec0)/tics);
  for(i=1;i<n0;i++)
    //if (a[i]>a[i+1]) {
     // printf("Bad\n");
     // return 0;
     printf("%ld\n",a[i]);

  //printf("Good\n");
}








