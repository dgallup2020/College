#!/usr/local/bin/node

/**
 * Get the first three command line parameters as integers.  The first integer
 * represents the start, the second the end and the third number the skip.
 * Print the numbers from the start until the end skipping every skip number
 * of numbers.
 *
 * Example input/output:
 * ./l3.js 2 11 3
 * 2
 * 5
 * 8
 * 11
 */
 var i = 0;
var a = parseInt(process.argv[2]);
var b = parseInt(process.argv[3]);
var c = parseInt(process.argv[4]);
//for (i=a; i<b+1 ;i+=c){
//
 // console.log(i);
//}
while (i<b){
  
i=i+c
console.log(i);
}
