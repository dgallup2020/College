#!/usr/local/bin/node

/**
 * Create a function called 'dprint' that takes one argument and prints it out
 * to the console log _twice_.
 */
function dprint(x1)
{console.log(x1);
  console.log(x1);
}



/**
 * Create a function call 'add' that takes two arguments, adds them together then
 * calls dprint defined above to print out the result.
 */
function add(x1,x2)
{
 dprint(x1+x2);


}



/**
 * Call the add function with the 1st and 2nd command line arguments (stored
 * in process.argv[2] and process.argv[3] respectively.
 */

add(process.argv[2], process.argv[3]);