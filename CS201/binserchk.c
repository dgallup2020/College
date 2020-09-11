#include<stdio.h>
#define R 200000

long a[R];
int cnt = 0;

void binSearch(long sv, int l, int r) {
  cnt++;
  //printf("left = %d, right=%d middle=%d\n", l,r, (l+r)/2);
  if (r<l) {
    //printf("NOT found\n");
    return;
  }
  int m = (l+r)/2;
  if (sv == a[m])  {
     printf("%ld\n", sv);
     return;
  }
  else if (sv > a[m]) 
      binSearch(sv, m+1, r);
  else
    binSearch(sv, l, m-1);
  
}

int main() {
  int end; //index of the last item
  //fill 0..end positions with integers from a sorted file file
  int i=0;
  FILE *f = fopen("num6", "r");
  while (1==fscanf(f, "%ld", a+i))
    i++;
  //
  fclose(f);
  end = i-1;
  f = fopen("num5", "r");
  long searchValue;
  while (1==fscanf(f, "%ld", &searchValue)) {
    //is that value in the array?
    binSearch(searchValue, 0, end);
  }
  fclose(f);
  printf("the number of comparisons is %d\n", cnt);
}
