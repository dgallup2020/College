#!/usr/local/bin/node

/**
 * The following loads a dictionary of words into the string data:
 */
const fs = require("fs");
var data = fs.readFileSync("/usr/dict/words", {encoding: 'utf8'});

/**
 * Split the string data into words using the split() method on data using
 * "\n" as the deliminator.  Assign the result to the variables "words":
 */
var words = data.split("\n");


/**
 * Assign the variable 'word' the string that is the first command line
 * parameter.
 */
var word = process.argv[2];


/**
 * Loop through words looking to see if 'word' is found in the list of words.
 * If it is, print "Found", if it isn't, print "Not found". Hint: Use a variable
 * as a flag (i.e. true or false) if the word is found.  You can use "break" to
 * exit the loop early if you do find the word.
 */



var flag=0
for(i=0;i<words.length;i++){
  if(words[i] == word){
    var flag = 1;
    break;
  }
}
if(flag == 0){
  console.log("Not found");
}
else{
  console.log("Found");
}
                                                                                                         
