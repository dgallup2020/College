#!/usr/local/bin/node

const fs = require("fs");
var data = fs.readFileSync(process.argv[2], {encoding: 'utf8'});

/**
 * Using the file input in data above, count the number of spaces, the number
 * of numbers and the number of letters and return a count for each of them.
 *
 * Example input/output:
 * ./l5.js l4.js
 * Spaces : 147
 * Letters: 571
 * Numbers: 6
 */
var i= 0
var sp= 0
var lett= 0
var num = 0
while(i<data.length){
if (data[i] == " "){
sp++;}
else if(data[i] >= "A" && data[i] <= "Z" || data[i] >= "a"  && 
data[i] <= "z"){
lett++
}
else if(data[i] >= "0" && data[i]<= "9"){
num++}
i++
}
console.log("Spaces : "+sp);
console.log("Letters: "+lett);
console.log("Numbers: "+num);


