#!/usr/local/bin/node

/**
 * The following code reads a file (file-name given as the first command line
 * parameter.  The files data is stored in the variable "data":
 *
 * const fs = require("fs");
 *  - Loads (requires) the "fs" library of functions, assigning it to a variable
 *    (fs) as an object with methods and properties.
 * var data = fs.readFileSync(process.argv[2], {encoding: 'utf8'});
 *  - Uses the readFileSync (Read a File Synchronously (i.e. wait for the file
 *    data before continuing)) in the fs object to read the file specified by
 *    the first command line argument.
 */
const fs = require("fs");
var data = fs.readFileSync(process.argv[2], {encoding: 'utf8'});

/**
 * Using the string 'data', count the number of periods (.) in data and print
 * the count.
 * Example input/output:
 * ./l4.js l5.js
 * # of periods = 6
 */
//for (i=x=0,i<data.length;i++;)
//if (date[i] == " . ");
//x++;
//
//console.log("# of periods = "+x);
var i = 0
var x = 0 
while(i<data.length){
if (data[i] == "."){
x++;
}
i++
}
console.log("# of periods = "+x);

