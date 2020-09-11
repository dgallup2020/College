#include<stdio.h>
#include<sys/times.h>
#include<unistd.h>
#define R  200000
long a[R];

//find index of the largest item between index 0 and index end
//This function will make end comparisons
int maxPos(int end) {
  int pos = 0;
  int i;
  for(i=1; i<=end; i++)
	  if (a[i] > a[pos])
		  pos = i;
  return pos;
}


// uses maxPos to sort the array
int main() {
  struct tms buf;
  long tics = sysconf(_SC_CLK_TCK);
  int end; //index of the last item
  //fill 0..end positions with integers from a file
  int i=0;
  while (1==scanf("%ld", a+i))
    i++;
  //
  end = i-1;

   //sort the array
  long sec0=times(&buf);
   while (end>0) {
     int mp = maxPos(end);
     //swap the values at mp and end
     int tmp = a[mp];
     a[mp] = a[end];
     a[end]= tmp;
     //
     end--;
  }
  printf("%f\n", (double)(times(&buf)-sec0)/tics);
}








