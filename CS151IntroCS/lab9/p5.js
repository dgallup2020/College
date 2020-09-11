#!/usr/local/bin/node

/**
 * Take the first four command line parameters (a b and c), convert them to
 * an integer. They will be either zero or one.  Produce the output "pass"
 * or "fail" depending on the values of a, b, c and d using the following table:
 *
 * a | b | c | d | output	a | b | c | d | output
 * ----------------------	----------------------
 * 0 | 0 | 0 | 0 | "fail"	1 | 0 | 0 | 0 | "pass"
 * 0 | 0 | 0 | 1 | "pass"	1 | 0 | 0 | 1 | "fail"
 * 0 | 0 | 1 | 0 | "pass"	1 | 0 | 1 | 0 | "fail"
 * 0 | 0 | 1 | 1 | "fail"	1 | 0 | 1 | 1 | "fail"
 * 0 | 1 | 0 | 0 | "pass"	1 | 1 | 0 | 0 | "fail"
 * 0 | 1 | 0 | 1 | "fail"	1 | 1 | 0 | 1 | "fail"
 * 0 | 1 | 1 | 0 | "fail"	1 | 1 | 1 | 0 | "fail"
 * 0 | 1 | 1 | 1 | "fail"	1 | 1 | 1 | 1 | "fail"
 * 
 * Example input/output:
 * ./p5.js 0 0 0 1
 * pass
 * ./p5.js 0 1 0 1
 * fail
 */

var a= parseInt(process.argv[2]);
var b= parseInt(process.argv[3]);
var c= parseInt(process.argv[4]);
var d= parseInt(process.argv[5]);
if ((!a&&!b&&!c&&d) || (!a&&!b&&c&&!d) || (!a&&b&&!c&&!d) || (a&&!b&&!c&&!d)) {
  console.log("pass");
}
else {
  console.log("fail");
}