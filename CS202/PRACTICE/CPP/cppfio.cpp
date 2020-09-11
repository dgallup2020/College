#include <iostream>
#include <fstream>
#include <stdlib.h>

using namespace std;

int main(int argc, char* argv[]){

  ifstream f_in;
  f_in.open(argv[1]);
  
  string filename = argv[1]; filename += ".new";
  ofstream f_out; f_out.open(filename.c_str());
  
  string s;
  
  while(f_in >> s){
    cout << s << "\n";
    f_out << s << " ";
  }
  
  f_in.close();
  f_out.close();
  

  return 0;
}
