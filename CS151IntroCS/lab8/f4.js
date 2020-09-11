#!/usr/local/bin/node

/**
 * Create a global variable called seed and set it to the integer value of the
 * first command line argument.
 */
var seed= parseInt(process.argv[2]);

/**
 * Create a function called "rand" that takes no parameters.  Rand should have
 * three local variables, set to the following:
 *   a = 1103515245
 *   b = 12345
 *   m = Math.pow(2,32)
 * The function should set the global seed variable to the result of
 *   (a * seed + b) % m
 * return the new value of seed as the return value of the function rand.
 */

function rand()
{
a = 1103515245
b = 12345
m  = Math.pow(2,32)
seed = (a * seed + b)%m
return seed

}


/**
 * Print out the result of the function rand defined above modulo 100, 5
 * different times.
 */


console.log(rand()%100);
console.log(rand()%100);
console.log(rand()%100);
console.log(rand()%100);
console.log(rand()%100);

