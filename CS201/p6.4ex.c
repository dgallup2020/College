#include<stdio.h>
//Which letters are most frequent its similar to #1 but sorts
//Frequencies start at 0; Characters are read in and counted
//Finally the array is sorted from smallest frequency to largest
//Printed


int main(){

struct letFreq {
  char letter;
  int f;
  };

struct letFreq lf[26];//set the letters

int i;
for(i=0; i<26; i++){ //set freq equal to zero
  lf[i].f=0;
  lf[i].letter='A'+i;
}
char c;
while(1==scanf("%c",&c)){//scanner and counter on lf.f
  if(c>='A' && c<='Z')
    lf[c-'A'].f++;
  if(c>='a' && c<='z')
    lf[c-'a'].f++;
}
struct letFreq tmp;
tmp.f=0;
tmp.letter='a';
int j,k; 
for(k = 0; k < 26; k++){ //bubble sort

  for(j = 0; j < (26-1); j++){
  if(lf[j].f > lf[j+1].f){
    tmp = lf[j+1];
    lf[j+1] = lf[j];
    lf[j]=tmp;
    }
  }
}
for(i=0;i<26;i++){
  printf("%c %d\n",lf[i].letter,lf[i].f);
  }
}


