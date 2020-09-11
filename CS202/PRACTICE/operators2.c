#include<stdio.h>
#include<stdlib.h>

int main(int argc,char * argv[]){
//1.
char a = 97;
printf("%c\n",a);

//2.

printf("%i\n",a);

//3.

char b = 127;
printf("%i\n",b<<1);

//4.

printf("%i\n",b&15);

//5.

int c = (1<2) && (2<1);
printf("%i\n",++c);

//6. 
int d= (1<2) | (2<1);
printf("%i\n",d++);

//7.

int e=1;
switch(e){
case 1: e++;
case 2: e++;
case 3: e++;
default: e++;
}
printf("%d\n",e);

//8.

int f = 0;
for(f;f<5;f++)
;
printf("%i\n",f);

//9.
int g = 0;
while((g=1)>2)
  g++;
printf("%d\n",g);

//10.

char h = 127;
h++;
printf("%d\n",h);
}
