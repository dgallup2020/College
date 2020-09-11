#!/usr/local/bin/node

/**
 * Save the first command line argument as an integer into a variable called n.
 */
var n = parseInt(process.argv[2]);



/**
 * Print a right angled triangle out of stars that is n rows high.
 * Example input/output:
 * ./l6.js 5
 * *
 * **
 * ***
 * ****
 * *****
 */
for(i=1;i<=n;i++){
  var a = ""
  for(j=0;j<i;j++){
    a+= "*";  
  }
  console.log(a);
}

