#include<stdio.h>
class Fraction {
private:
  int num;
  int den;
public:
  //constructor
  //if the fraction is negative, include the minus sign with 
  //the numerator
  Fraction(int n, int d) {
    if (d==0)  {//error 
                return;
               }
   
    if (d<0) {
      n = -n; d=-d;
    }
    int n1 = (n<0)?-n:n;
    int g = gcd(n1,d);
    num = n/g;
    den = d/g;
  }

  Fraction operator*(Fraction f) {
     return Fraction(num*f.num, den*f.den);
  }
  Fraction operator+(Fraction f) {
    if(den==f.den)
    return Fraction(num+f.num,den);
    else{
    return Fraction((f.den*num+f.num*den),den*f.den);
    }
    }

  //access the value of the numerator
  int getNum() {
    return num;
  }

  //access the value of the denominator
  int getDen() {
    return den;
  }

  //returns the greatest common divisor of a, b
  int gcd(int a, int b) {
    if (b==0) return a;
    int r = a%b;
    return gcd(b,r);
  }
};


//user of the class; can use the public members of the class
int main() {
  Fraction f1(3,2);
  Fraction f2(4,5);
  Fraction f3 = f1*f2;   //f1.operator*(f2)
  printf("%d %d\n", f3.getNum(), f3.getDen() );
  Fraction f4(1,3);
  Fraction f5(1,5);
  Fraction f6 = f4+f5;
  printf("%d %d\n", f6.getNum(), f6.getDen() );
}
