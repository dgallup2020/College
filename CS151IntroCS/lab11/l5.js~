#!/usr/local/bin/node

const fs = require("fs");
var data = fs.readFileSync(process.argv[2], {encoding: 'utf8'});

/**
 * Split the input (data) into lines using the split method using the "\n"
 * (newline) as the deliminator. Store the results into the variable 'lines'
 */

var lines = data.split("\n");

/**
 * Loop through all the lines, check the length of each line and keep track of
 * the length of the longest line.  At the end print the length of the longest
 * line that was in the file. Example input/output:
 * ./l5.js l5.js
 * The longest line is 78 characters long.
 */
var max = lines[0].length;
for(i=0;i<lines.length;i++){
if(lines[i].length>max){
var max = lines[i].length;
	}
}
console.log("The longest line is "+max+" characters long.");
