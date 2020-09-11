#!/usr/local/bin/node

/**
 * Using the binary() function below make a function called octal that does
 * the same thing binary does, but returns the number as an octal string.
 * Note that an Octal number should have a leading 0.
 */


function binary(n) {
  var b = "";
  for(var i=0; n > 0; i++) {
    b = (n % 2) + b;
    n = Math.floor(n/2);
  }
  return "0b" + b;
}
function octal(n) {
  var o = "";
  for(var i=0; n > 0; i++) {
    o = (n % 8) + o;
    n = Math.floor(n/8);
  }
  return "0" + o;
}







/**
 * Do it again and make a function called "hex" that returns the input number
 * as a hexadecimal string. Hint:
 * var hexdigit = "0123456789ABCDEF";
 * Note that a hex number should have a leading 0x:
 */

function hex(n) {
  var hexdigit = "0123456789ABCDEF";
 var h = "";
  for(var i=0; n>0; i++) {
   
    h = hexdigit[(n % 16)] + h
    n = Math.floor(n/16);
  }
  return "0x"+ h;
}






/**
 * Using the above three functions (binary, octal and hex), get the first
 * command line argument as an integer and output the value in decimal,
 * hex, octal and binary respectively. Example input/output:
 * ./l3.js 53
 * Dec : 53
 * Hex : 0x35
 * Oct : 065
 * Bin : 0b110101
 */
var n = parseInt(process.argv[2]);

console.log("Dec : "+ n);
console.log("Hex : "+ hex(n) );
console.log("Oct : "+ octal(n) );
console.log("Bin : "+ binary(n) );



