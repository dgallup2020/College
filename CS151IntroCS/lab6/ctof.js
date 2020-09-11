#!/usr/local/bin/node
var C=parseFloat(process.argv[2]).toFixed(2);
var F= ((C*9/5)+32).toFixed(2);
console.log(C + " degrees C = "+ F+"F");