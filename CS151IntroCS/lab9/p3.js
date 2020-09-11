#!/usr/local/bin/node


/**
 * Take the first three command line parameters (a b and c), convert them to
 * an integer. They will be either zero or one.  Produce the output "pass"
 * or "fail" depending on the values of a, b and c using the following table:
 *
 * a | b | c | output
 *-------------------
 * 0 | 0 | 0 | "pass"
 * 0 | 0 | 1 | "fail"
 * 0 | 1 | 0 | "fail"
 * 0 | 1 | 1 | "fail"
 * 1 | 0 | 0 | "pass"
 * 1 | 0 | 1 | "pass"
 * 1 | 1 | 0 | "fail"
 * 1 | 1 | 1 | "pass"
 * 
 * Example input/output:
 * ./p3.js 0 1 0
 * fail
 * ./p3.js 0 0 0
 * pass
 */
//(~A+~B)*B
var A= parseInt(process.argv[2]);
var B= parseInt(process.argv[3]);
var C= parseInt(process.argv[4]);

/**if ((!(A && B && C)) == 1){
  console.log("pass");
}
else if ((A && !B && !C) == 1) {
  console.log("pass");
}
else if ((A && !B && C) == 1) {
  console.log("pass");
}
else if ((A && B && C) == 1) {
  console.log("pass");
}
else {
  console.log("fail");
  }
  */
if ((!A&&!B&&!C) || (A&&!B&&!C) || (A&&!B&&C) || (A&&B&&C)) {
  console.log("pass");
}
else
{
  console.log("fail");
}
  var val = a*4+b*2+c
// binary calculator