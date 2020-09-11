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
 * Loop through the array and find the _second_ smallest value within and print
 * it out.
 * Example input/output:
 * ./l2.js testdata
 * -481
 */

var small = Math.min(a[0],a[1]);
var small2nd = Math.max(a[0],a[1]);

for(i=2;i<a.length;i++){
	if(small >  a[i]){
	       small2nd = small;
		small = a[i];
 	}
	if(a[i] > small && a[i] < small2nd){
		small2nd = a[i]
	}
}
console.log(small2nd);
  
