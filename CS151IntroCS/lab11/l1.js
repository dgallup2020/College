#!/usr/local/bin/node

/**
 * Get the string from the first command line argument and store it in s:
 */
var s= process.argv[2];


/**
 * Use a loop to scan the string and keep a counter, initialized to zero.
 * If you encounter a '(' in the string, increment the counter.
 * If you encounter a ')' decrement the counter.
 * If the counter ever goes below 0, quit the loop and print "Unbalanced )"
 * If at the end of the string the counter is above zero, print "Unbalanced ("
 *   otherwise print "Balanced".
 */

var count=0
for(i=0;i<s.length;i++){
  if(s[i] == "("){
    count++;
  }
  else if(s[i] == ")"){
    count--;
  }
  if(count<0){
    break;
  }
}
if(count<0){
  console.log("Unbalanced )");
}
else if(count>0){
  console.log("Unbalanced (");
}
else
{
  console.log("Balanced");
}
  
  
  
 