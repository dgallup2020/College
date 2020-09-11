#include <iostream>
#include <string.h>

using namespace std;

int main(int argc, char* argv[]){
  
  cout << "(starting point for this program:\n cs20203/HW/lab13/lab13_io.cpp)\n";
  cout << "Programmer's note: responses to try -\n";
  cout << " well, bad, Harry Potter, Hitchhiker's Guide, Lord of the Rings)\n";
  cout << "(And string comparisons in program are case sensitive.)\n\n";
  
  
  string s;
  
  int temp;
  
  cout << "Hello.  How are you?\n  ";
  getline (cin, s);
  
  //looking for how are you
  temp = s.find("well");
  
  if(temp==0)
    cout << "Awesome, me too.\n";
  
  temp = s.find("bad");
  
  if(temp == 0)
    cout << "Too bad, sorry to hear that\n";
  
  else 
    cout << "Okay.\n";
  
  cout << "What is your favorite movie?\n  ";
  getline(cin, s);
  
  temp = s.find("Harry Potter");
  if(temp==0)
    cout << "In that case, expeliarmus!\n";
  
  temp = s.find("Lord of the Rings");
  if(temp==0)
    cout << "Okay precious.\n";
  
  temp = s.find("Hitchhiker's Guide");
  if(temp==0)
    cout << "Okay, 42 and what not.\n";
  
  else
    cout << "I haven't heard of that one, I'll have to check it out.\n";
  
  cout << "Alright, I have to go. See you later.\n";
  getline(cin,s);
  return 0;
}