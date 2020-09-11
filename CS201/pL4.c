#include<stdio.h>
#include<stdlib.h>
#define SZ 65536

//searchs a file of numbers to print out the repeats

struct box {
  long val;
  struct box *next;
};

struct box *head[SZ];

int search(int hv, long n){ //searches for number in the hash list
  struct box *curr = head[hv];
  while(curr!=0){
  if(curr->val==n)
    return 1;
  curr = curr->next;
  }
  return 0;
}

void insert(int hv, long n) { //inserts a number in front of the list
  struct box *curr  = head[hv];
  struct box *prev = curr; 
  struct box *nb = malloc(sizeof(struct box));
  if(head[hv]==0){
  nb->val=n;
  nb->next=0;
  head[hv]=nb;
  }
  else{
  nb->val=n;
  nb->next=head[hv];
  head[hv]=nb;
  }
}


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

int main() {
  long mask = 0xFFFF;
  FILE *f = fopen("num3", "r");
  long n;
  while(1==fscanf(f,"%ld",&n)){
   int hv = h(n);
      if(search(hv,n)==1){
      printf("%ld\n",n);
      //  printf("you have a copy \n");
        continue;
      }
      else{
        insert(hv,n);
      }
}
fclose(f);
}







