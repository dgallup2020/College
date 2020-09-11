#!/usr/local/bin/node
var F=parseFloat(process.argv[2]).toFixed(2);
var C= ((F-32)*5/9).toFixed(2);
console.log(F + " degrees F = "+ C+"C"); 