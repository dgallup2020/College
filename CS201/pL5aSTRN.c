#include<stdio.h>
#include<stdlib.h>

#define SZ 65536

struct box {
  long val;
  struct box *next;
};

struct box *head[SZ];


int c[SZ];  //initialized to 0
int cnt[13];


int h(long n) {
  long mask = 0xFFFF;
  int quarter1 =  n&mask;
  long n1 =   n>>16;
  int quarter2 = n1&mask;
  long n2 = n1>>16;
  int quarter3 = n2&mask;
  long n3 = n2>>16;
  int quarter4 = n3&mask;
  return quarter1^quarter2^quarter3^quarter4;
}

int cmpnCount;

int search(long v) {
  int hv = h(v);
  struct box * curr = head[hv];
  while (curr!=0) {
    cmpnCount++;
    if (curr->val==v) return 1;
    curr = curr->next;
  }
  return 0;
}


int main() {

  //open the file num3; building the hash table
  FILE *f = fopen("num3", "r");
  long n;
  int count=0;
  while (1==fscanf(f, "%ld", &n)) {
     if (search(n))
       ;  //printf("%d\n", n); //finding duplicates in num3
    else {
      int hv = h(n);
      c[hv]++;
      struct box *nb = malloc(sizeof(struct box));
      nb->val = n;
      nb->next = head[hv];
      head[hv]=nb;
    }
  }
  fclose(f);
   //Have built the hash table for the file num3
  //open num5
  f = fopen("num5", "r");
  cmpnCount=0;
  while (1==fscanf(f, "%ld", &n)) {
    //Is n in the hash table?
    if (search(n)==1) {
       printf("%d\n", n); 
    }
    //what is the cost to find out? (number of comparisons)
  }
  //loop done
  printf(" cost is %d\n", cmpnCount);
}









