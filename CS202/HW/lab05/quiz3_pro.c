#include<stdio.h>
#include<stdlib.h>

int main(int argc, char * argv[]){
  int num1 = 123456;
  int i;
  for(i=0;i<3;i++)
    num1 = num1 + (1 << i); 
  printf("%d\n",num1);
  return 0;
}
//123463


//2. 




//3. (True/False) A variable of an enumerated (enum) type only takes one 
//value? Answer: True
