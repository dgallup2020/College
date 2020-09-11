#include <iostream>
#include <stack>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>

using namespace std;


int doOperation(int left, int right, const char * op) {
  if (strcmp(op, "+") == 0) return left+right;
  if (strcmp(op, "*") == 0) return left*right;
  if (strcmp(op, "-") == 0) return left-right;
  if (strcmp(op, "/") == 0) return left/right;
  if (strcmp(op, "%") == 0) return left%right;
  if (strcmp(op, "^") == 0) return left^right;
  if (strcmp(op, "&") == 0) return left&right;
  if (strcmp(op, "|") == 0) return left|right;
  if (strcmp(op, "||") == 0) return left||right;
  if (strcmp(op, "&&") == 0) return left&&right;
  if (strcmp(op, ">>") == 0) return left>>right;
  if (strcmp(op, "<<") == 0) return left<<right;
  
  if (strcmp(op, "<") == 0) return left<right;
  if (strcmp(op, "<=") == 0) return left<=right;
  if (strcmp(op, ">") == 0) return left>right;
  if (strcmp(op, ">=") == 0) return left>=right;
  if (strcmp(op, "!=") == 0) return left!=right;
  if (strcmp(op, "==") == 0) return left==right;

  return right;
}

int main(int argc, char *argv[]){
  
  cout << "WARNING: careful with using operations that mean" << endl
       << "  something to the shell, like *.  Put those in quotes." << endl << endl;
  
  stack<int> mystack;
  
  for(int i=1; i < argc; i++){
    char *s = argv[i];
     // string s = argv[i];  // we could have done that, but wasteful copying
    
    // if it is a number - put it on stack
    if (isdigit(s[0])) {
      //cout << "number: " << s << endl;
      mystack.push(atoi(s));
      cout << " (pushing number onto stack: " << s << ")" << endl;
    }    
    // else - pop off top two numbers from stack, do operation, put result on stack
    else {
      //cout << "operation: " << s << endl;
      int rightVal = mystack.top(); mystack.pop(); cout << "  (popped off of stack: " << rightVal << ")" << endl;
      int leftVal = mystack.top(); mystack.pop(); cout << "  (popped off of stack: " << leftVal << ")" << endl;

      int newVal = doOperation(leftVal, rightVal, s);
      cout << " (doing operation " << s << ")" << endl;
      mystack.push(newVal);
      cout << " (pushing number onto stack: " << newVal << ")" << endl;
    }
    
  } 
  cout << mystack.top() << endl;
  
  return 0;
}