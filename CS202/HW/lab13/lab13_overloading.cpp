#include <iostream>

using namespace std;

class rational {
public:
  int top, bottom; // 1/4 has top 1 and bottom 4

  // + operator
  rational operator+(const rational right) const {
    rational newR;
    
    newR.top = top * right.bottom + right.top * bottom;
    newR.bottom = bottom * right.bottom;
    
    return newR;
  }

  // = operator
  rational operator=(const rational rhs) {
    top = rhs.top;
    bottom = rhs.bottom;

    return *this; // note: this is a pointer to myself
  }

  rational operator*(const rational right) const {
    rational newR;

    newR.top = top * right.top;
    newR.bottom = bottom * right.bottom;
    return newR;
  }

  rational operator-(const rational right) const {
    rational newR;

    newR.top = (top * right.bottom) - (right.top * bottom);
    newR.bottom = bottom * right.bottom;
    return newR;
  }
  
  rational operator/(const rational right) const {
    rational newR;
    newR.top = top * right.bottom;
    newR.bottom = bottom * right.top;
    return newR;
  }

  void print() {
    cout << top << "/" << bottom << endl;
  }
};

int main(int argc, char *argv[]) {
  cout << "(starting point for this program:\n";
  cout << "u1/class/cs20203/HW/lab13/lab13_overloading.cpp)\n";
  rational q1; // 1/4
  cout.width(11); cout << left << "q1.top:"; cin >> q1.top; 
  cout.width(11); cout << left << "q1.bottom:"; cin >> q1.bottom; 
  //q1.top = 1; q1.bottom = 4;
  q1.print();

  rational q2; // 1/3
  //q2.top = 1; q2.bottom = 3;
  cout.width(11); cout << left << "q2.top:"; cin >> q2.top;
  cout.width(11); cout << left << "q2.bottom:"; cin >> q2.bottom;
  q2.print();

  rational q3;

  //addition cause
  q3 = q1 + q2;
  cout << "q1+q2 = "; q3.print();

  //subtraction cause
  q3 = q1-q2;
  cout << "q1-q2 = "; q3.print();

  //multiplication
  q3 = q1 * q2;
  cout << "q1*q2 = "; q3.print();
  
  //division
  q3 = q1 / q2;
  cout << "q1/q2 = "; q3.print();
  
  
  return 0;
}
