#!/usr/local/bin/node

/**
 * Save the first command line argument as an integer into a variable called n,
 * and the second command line argument as an integer into a variable called m.
 */

var n = parseInt(process.argv[2]);
var m = parseInt(process.argv[3]);

/**
 * Make a box of *'s that is n columns by m rows in size:
 * Example input/output:
 * ./l5.js 5 4
 * *****
 * *****
 * *****
 * *****
 */

for(i=0;i<m;i++){
    var a  = ""
	for(j=0;j<n;j++){
	a+="*"
	}
console.log(a);
}

		
