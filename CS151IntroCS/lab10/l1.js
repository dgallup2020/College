#!/usr/local/bin/node

/**
 * Convert the first command line argument to an integer, then make a loop to
 * print "Hello, world!" the number of times that the integer tells you to.
 *
 * Example input/output:
 * ./l1.js 3
 * Hello, world!
 * Hello, world!
 * Hello, world!
 */
var i=0
var n = parseInt(process.argv[2]);
//for (i=0; i<n; i++)
//  console.log("Hello, world!");
while (i<n){
console.log("Hello, world!");
i++;
}
