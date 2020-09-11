#!/usr/local/bin/node
var PV= parseFloat(process.argv[2]).toFixed(2);
var APR= parseFloat(process.argv[3]).toFixed(2) ;
var years= parseInt(process.argv[4]).toFixed(2);
var months= 12*years;
var rate= APR/100/12
console.log("Principle is: $" +PV+ " at " +APR+ "% APR for " +years+ " years");

var payment= ((PV *rate*Math.pow((1+rate),months))/(Math.pow(1+rate,months)-1));
var total=(months*payment).toFixed(2);
console.log("Monthly payment is: $"+ payment.toFixed(2));
console.log("Total payments is : $"+ total);
//Math.pow((1+rate),months)