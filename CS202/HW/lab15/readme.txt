Due: Nov 8

Grading: 3 points / problem

Quiz over this on Nov 9?  

Put into the file ~/HW/lab15/readme.txt the name of the file with your answers
(in the lab15 directory).  You can use a text file, word document, whatever.

Note - in this file ^ means exponent, not XOR.

1) Put the following into big-O order, and "give reasons" why:
   
   f0(n) = 5 * n
   -O(n) : any constant multiplied by a variable is just the variable
   
   f4(n) = (log n)^5
   -O((log n)^5) : logs to any power are almost as small as a linear variable
   
   
   
   f1(n) = 10 * log(n)
   -O(log(n)) : any constant multiplied by a variable is just the variable

   

      
   f2(n) = n * log(n)
   -O(n*log(n)) : Pluging in large numbers causes the n to take over the time complexity 

   f8(n) = 4 * sqrt(log n)
   -O(4^log(n)) : the square root makes slows down the time complexity
   
   
   f3(n) = n^2 / 10
   -O(n^2) : dividing with a constant has no effect on time complexity

   
   
   
   
   f5(n) = 1.5 ^ (sqrt(n))
   -O(1.5^sqrt(n))
   
   f6(n) = 1.5 ^ n
   -O(1.5^n)
   
   f7(n) = (log n) ^ (3 * log n)
   -O(log(n)^log(n))
   
   
   
   f9(n) = n! (use Sterling's formula)
   -O(n!)
   
   f10(n) = (n choose n/2) (look up def of combinations, use Sterling's formula, assume n is even)
   
   
   f11(n) = n ^ n
   -O(n^n)
   
   f12(n) = 2 ^ (2 ^ n)
   -O(2^2^n)


2) Let f(n) = 4 * n^2 - 5 * n + log(n), g(n) = n^3 / 4, h(n) = n * log(n) + 2 * n

f(n) = O(n^2)
g(n) = O(n^3)
h(n) = O(n*log(n))


Complete the following table with yes/no
			<=	>=	==	<	>
	     	       O     Omega	Theta	o	omega	>= for all n>=1		<= for all n>=1
f(n) is __ of g(n)     yes   no		no	yes	no	no			yes
g(n) is __ of f(n)     no    yes	no	no	yes	yes			no
f(n) is __ of h(n)     no    yes        no	no	yes	yes			no
h(n) is __ of f(n)     yes   no		no	yes	no	no			yes
g(n) is __ of h(n)     no    yes	no	no	yes	yes			no
h(n) is __ of g(n)     yes   no		no	yes	no	no			yes


Example, w(n) = n, v(n) = n^2, z(n) = 5 * n^2 + 10 * (log n)^4 - 2 * n

	     	       O     Omega	Theta	o	omega	>= for all n>=1		<= for all n>=1
w(n) is __ of v(n)     yes   no		no	yes	no	no     	   		yes    	  	
v(n) is __ of w(n)     no    yes	no	no	yes	yes			no
z(n) is __ of v(n)     yes   yes	yes	no	no	


3) Tree for the recurrence relation: T(n) = 3 * T(n/3) + n
   (Note we did on the board T(n) = 2 * T(n/2) + n, also did T(n) = 4 * T(n/2) + n)

   Include in your tree/picture at each level:
      depth, # nodes, running time / node, total running time
      
   Include the depth of the tree and the total running time when you
      add up the whole tree
      
      
			    n
				
	   n/3  	   n/3      	    n/3
	
      n/6	n/6	n/6	n/6	n/6	n/6
      
      
      depth | # nodes  | O(n)/node 	| run time/depth
      1		1	     n			n
      2		3	    n/3			n
      3		9           n/9			n
      i		3^(i-1)	    n/(3^(i-1))		n
      1
      
      depth: log3(n) + 1 = i
      Total tree run time: O(n)
      
      
      
