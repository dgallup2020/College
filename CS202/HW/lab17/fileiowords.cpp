#include <iostream>
#include <string>
#include <fstream>
using namespace std;

int main(int argc, char* argv[]){

  ifstream myfile;
  //myfile.open((string)argv[1]);
  
  string word;
  while(cin >> word)  
    cout << word << '\n';

  //myfile.close();
  return 0;

}
