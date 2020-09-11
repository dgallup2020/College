#include<stdio.h>
#include<stdlib.h>

void swapper(unsigned int x){
  int b1 = ((x>>24)& 0xff)<<16;
  int b2 = ((x>>16)& 0xff)<<24;
  int b3 = ((x>>8)& 0xff);
  int b4 = (x&(0xff))<<8;
  int final = b1&b2;
  int final2 = b3&b4;
  printf("%x hex\n",final);
  printf("%d dec\n",final);
  printf("%x hex\n",final2);
  printf("%d hex\n",final2);


}

int main(int argc, char*argv[]){

  //swapper(atoi(argv[1]));
  unsigned int y;
  //scanf("%x",y);
  swapper(0x00123456);
  return 0;
}
