#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdio.h>


using namespace std;


class animal {
public:
  string name;
  int years;
  int legs;
  string environment;
  
  void print(){
    cout << name << endl << "years: " << years << endl;
    cout << "legs: " << legs << endl << "environment: " << 
    environment << endl;
  }


};

int main(int argc, char* argv[]){

  animal a1;
  a1.name =  "TIGER";
  a1.years = 3;
  a1.legs = 4;
  a1.environment =  "savana";
  
  a1.print();
  
  
  return 0;
}
