#include<stdlib.h>
#include<stdio.h>

int main(){
  int roar[5] = {6,7,8,9,10};
  int a=2;
  int j = a == 2&3 << 3;
  //int k <<= 2;
  int y = 2&& (2&3);
  printf("%i\n",j);
  printf("%i\n",y);
  int  wow = *roar;
  //2&3 == 2;
  wow += wow++ + 7 << 2;
  printf("%i\n",wow);
  return 0;
}
