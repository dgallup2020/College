#!/usr/local/bin/node

/**
 * Given:
 * A = the first command line parameter and
 * B = the second command line parameter
 *
 * if A is less than B    output: A + " is less than " + B	
 * if A is equal to B     output: A + " is equal to " + B
 * if A is greater than B output: A + " is greater than " + B
 * 
 * Example input/output:
 * ./p2.js abc def
 * abc is less than def
 */

var abc = parseInt(process.argv[2]);
var def = parseInt(process.argv[3]);
if (abc < def){
  console.log(abc + " is less than " + def);
}
else if (abc == def){
  console.log(abc + " is equal to " + def);
}
else if (abc > def){
  console.log(abc + " is greater than " + def);
}