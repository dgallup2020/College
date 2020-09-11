#!/usr/local/bin/node

/**
 * Open and read the file given as the first command line argument and put
 * it's contents into "data":
 */
const fs = require("fs");
var data = fs.readFileSync(process.argv[2], {encoding: 'utf8'});




/**
 * data above is a JSON encoded string of an array of numbers, use the
 * JSON.parse() method to turn it back into an array of numbers stored in the
 * variable a:
 */

var a = JSON.parse(data);

/**
 * Go through the array of numbers and sum (add together) the numbers in the
 * array.  Print out the result.
 * Example input/output:
 * ./l3.js testdata
 * 4656
 */
var total = 0
for(i=0;i<a.length;i++){
	total = total + a[i]
}
console.log(total);
