#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char * argv[]) {
// read from standard input until EOF and print
// the words read in reverse order.
      cout << "(starting point for this program:\n";
      cout << "/u1/class/cs20203/HW/lab13/lab13_vector.cpp)\n";
      cout << "Type numbers (stored as double), ctrl-d to quit" << 
      endl;

      double s;
      double total = 0;
      vector<double> nums; // vector is basically an array that can 
      //grow in size

      while ( cin >> s) { // while (scanf("%99s", s) == 1) {
          //cout << s << " ";
          nums.push_back(s); // add string to words ; // strcpy(A[i], 
          //s); i++
          total+=s;
      }
// print words in reverse order.  note: they typed 3 words, words.size() is 3
      cout << "Total: " << total << endl;
      for(int i = 0; i < nums.size(); i++){
      //for(int i = nums.size() - 1; i >= 0 ; i--) {
          cout << nums[i] << ", " << ((nums[i]/total)*100);
          cout << " percent of total\n";
      }
      return 0;
}

