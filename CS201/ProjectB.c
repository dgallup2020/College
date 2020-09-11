//polynomials:  as we go throught the list, the exponents decrease 

struct term {
  double coef;
  int exp;   // exponent is >=0
  struct term *next;
};

class Poly {
private:
  struct term *head;
public:
 
  Poly() {      //empty constructor
     head = 0;
  }


  Poly(Poly const &p) { //copy constructor
    head = 0;
    term *curr = p.head;
    while (curr!=0) {
      addTerm(curr->coef, curr->exp);
      curr = curr->next;
    }
  }

  addTerm(double newCoef, int newExp) {
  }

  //multiplication of two polys

  //addition of two polys
  copy p1 to the result
  for each term of p2 add it to result  addTerm(coef, exp)
}

int main() {
  Poly p;
  p.addTerm(3.5, 2);
  p.addTerm(7, 10);
  p.addTerm( -3, 1);

  Poly p1
  Poly p2
  
  Poly p3 = p1+p2;
}
