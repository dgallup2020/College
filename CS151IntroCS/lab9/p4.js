#!/usr/local/bin/node

/**
 * Convert the first command line parameter to an integer and if the number is
 * divisible three output "Fizz".  If the number is divisible by five output
 * "Buzz".  If it is divisible by both 3 and 5 output "FizzBuzz".  If it is
 * not divisible by either 3 or 5 just output the number itself.
 * 
 * Example input/output:
 * ./p4.js 3
 * Fizz
 * ./p4.js 11
 * 11
 */

var a = parseInt(process.argv[2]);
if ((a%5 == 0) && (a%3 == 0)){
  console.log("FizzBuzz");
}
else if (a%5 == 0){
  console.log("Buzz");
}
else if (a%3 == 0){
  console.log("Fizz");
}
else {
  console.log(a);
}