#include <iostream>
#include <fstream>
#include <stdlib.h>

using namespace std;

int main(int argc, char *argv[]) {

  cout << "(starting point for this program:" << endl;
  cout << "/u1/class/cs20203/HW/lab13/lab13_files.cpp" << endl;

  if (argc < 2) {
    cout << "Usage: ./a.out filename.txt" << endl;
       exit(0);
  }

  ifstream f_in;      // declare file input stream variable f_in
  f_in.open(argv[1]); // open the file argv[1] for reading

  string filename = argv[1];
  cout << " Copying file " << filename << endl;
  filename += ".new";
  ofstream f_out; f_out.open(filename.c_str());
  
  string s;

  while (getline(f_in,s)) {   // call >> function on f_in
     //cout << s << " ";
     f_out << s << endl;// " ";
  }
  //figure out why the characters won't cp over;

  cout << "Copying done, new file is: " << filename << endl;

  f_in.close();
  f_out.close();

  return 0;
                                                }
