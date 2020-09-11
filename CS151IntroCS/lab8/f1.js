#!/usr/local/bin/node

/**
 * Complete the function foo below.  Make it take three parameters and return
 * the result of multiplying the first two and adding the third.
 */
function foo(x1,x2,x3) {
return x1*x2+x3
}

var n = parseInt(process.argv[2]);
var r = foo(n,n+1,n+2) + foo(n+3,n+4,n+5);
console.log(r);
