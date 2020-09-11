#!/usr/local/bin/node

/**
 * Opens and reads the file given as the first command line argument and puts
 * it's contents into "data":
 */
const fs = require("fs");
var data = fs.readFileSync(process.argv[2], {encoding: 'utf8'});

/**
 * Split the input (data) into lines using the split method using the "\n"
 * (newline) as the deliminator. Store the results into the variable 'lines'
 */
var lines = data.split("\n");



/**
 * Output the lines with the line number (starting at 1) before the line.
 * The number should be right-aligned to 5 spaces.
 * Hint:
 * 1) Convert the line number to a string (using the .toString() method on the
 *    number)
 * 2) get it's length using the .length property on the resulting string.
 * 3) Use the .substr(start [,length]) method on a string of spaces to select
 *    up to 5-length spaces to prepend to the number.
 * Example input/output:
 * ./l4.js ./l4.js
 *     1 #!/usr/local/bin/node
 *     2 
 *     3 /**
 * ...
 */
//for(i=0,i<line.length;i++){
//console.log("     "+ i + lines[i]);
//}
for(i=0;i<lines.length;i++){
var x = "     "
console.log(x.substr(0,5-i.toString().length)+(i+1).toString()+lines[i])
}	
