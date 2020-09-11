#!/usr/local/bin/node

/* 10 points */
/**
 * Create a function called ftoc that is given an argument that is in degrees
 * Fahrenheit and returns its value as Celsius.  The formula for converting F
 * to C is:  C = (F-32) * 5/9
 */




/**
 * Get the first command line parameter, convert it to a real number and store
 * it in a global variable called F.
 */



/**
 * Print the result of calling ftoc with F values that are -5, +0 and +5 degrees
 * more than F.  Output the results to 2 digits of precision after the decimal
 * point.
 * Example input/output:
 * ./t1.js 50
 * 7.22
 * 10.00
 * 12.78
 */



function ftoc(F)
{
   return ((F-32)*5/9).toFixed(2);
}
var F=parseFloat(process.argv[2]);
  console.log(ftoc(F-5));
 
  console.log(ftoc(F));

  console.log(ftoc(F+5));
  
  