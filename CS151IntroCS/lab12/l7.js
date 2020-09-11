#!/usr/local/bin/node

/**
 * Save the first command line argument as an integer into a variable called n:
 */
var n = parseInt(process.argv[2]);


/**
 * Make a pyramid out of stars that is n rows high:
 * Example input/output:
 * ./l7.js 5
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 */
var bspace = n-1
for(row=1;row<n*2;row++){
if(row%2==0){
continue;}
  var a = "";
  var space = "";
  for(col=0;col<row;col++){
  	a+="*";
  }
  for(spa=0;spa<bspace;spa++){
  	space+=" ";
  }
bspace--;
console.log(space+a)

}

  
  

