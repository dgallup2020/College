#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char * argv[]){

  cout << "Type stuff, ctrl-d to quit" << endl;
  string s;
  vector<string> words;
  
  while (cin >> s){
    words.push_back(s);
  }  

  for(int i = words.size()-1; i>=0;i--){
    cout << words[i] << endl;
  }
  return 0;
}
