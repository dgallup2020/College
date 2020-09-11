#!/usr/local/bin/node

/**
 * Save the first command line argument as an integer into a variable called n
 */
var n = parseInt(process.argv[2])


/**
 * Make a function called pad that is given a number as its only argument and
 * returns a string with the number formatted as a string that has been padded
 * on the left with spaces until the string is exactly 4 characters wide:
 * i.e.: pad(20) returns "  20" as a string.
 */
var x = "    "
function pad (n){
return x.substr(0,4-n.toString().length);
return x2;
} 
console.log(x2);    


/**
 * Output a n x n multiplication table. Assume that all numbers are right
 * aligned to 4 spaces (using the pad function above):
 *
 * Hint:
 * The top two rows are separate loops to print the top numbers and the top
 * line. Below that will require a loop inside of a loop.  An outer loop for
 * each row and an inner loop for the columns.
 * example input/output:
 * ./l8.js 4
 *    *    1   2   3   4
 *     +----------------
 *    1|   1   2   3   4
 *    2|   2   4   6   8
 *    3|   3   6   9  12
 *    4|   4   8  12  16
 */


