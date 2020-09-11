#!/usr/local/bin/node

/**
 * 10 points
 * Output the following given the the following inputs for a and b:
 * 
 * a | b | output
 * --------------
 * 0 | 0 | "foo"
 * 0 | 1 | "bar"
 * 1 | 0 | "baz"
 * 1 | 1 | "frob"
 * 
 * If a or b have a value other than 0 or 1, output "Illegal input" instead.
 * 
 * Example input/output:
 * ./t3.js 0 1
 * bar
 * ./t3.js x 0
 * Illegal input
 */
var a = parseInt(process.argv[2]);
var b = parseInt(process.argv[3]);
if (a===0 && b===0){
  console.log("foo");
}
else if (a===0 && b===1){
  console.log("bar");
}
else if (a===1 && b===0){
  console.log("baz");
}
else if (a===1 && b===1){
  console.log("frob");
}  
else {
  console.log("Illegal input");
}
  


