#!/usr/local/bin/node
/**
 * Define a function called "rprint" that takes three parameters and prints them
 * out to the console log in reverse order (i.e. print the third argument first.)
 */
function rprint(x1,x2,x3)
{
console.log(x3);
console.log(x2);
console.log(x1);
}








rprint(process.argv[2], process.argv[3], process.argv[4]);
