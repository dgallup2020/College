// Add the difference 
//for lower case that difference gets subt

//converts lower case to uppercase

#include<stdio.h>
int myToupper(int c){
int buf = 'a'-'A';
if('a'<=c && c<='z'){
c = c-buf;
return c;
}
if('A'<=c && c<='Z')
return c;
}


