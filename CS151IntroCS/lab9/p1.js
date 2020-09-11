#!/usr/local/bin/node
/**
 * Convert the first command line parameter to a floating point value and
 * then print the grade.  Use the following for the grade distribution:
 * 97+ A+	77+ C+
 * 93+ A	73+ C
 * 90+ A-	70+ C-
 * 87+ B+	67+ D+
 * 83+ B	63+ D
 * 80+ B-	60+ D-
 *	 < 60 F
 *
 * Example input/output:
 * ./p1.js 98.5
 * Your grade = A+
 */
var grade = parseInt(process.argv[2]);
if (grade >= 97){
  console.log("Your grade = A+")
}
else if (grade >= 93){
  console.log("Your grade = A")
}
else if (grade >= 90){
  console.log("Your grade = A-");
}
else if (grade >= 87){
  console.log("Your grade = B+");
}
else if (grade >= 83){
  console.log("Your grade = B");
}
else if (grade >= 80){
  console.log("Your grade = B-");
}
else if (grade >= 77){
  console.log("Your grade = C+");
}
else if (grade >= 73){
  console.log("Your grade = C");
}
else if (grade >= 70){
  console.log("Your grade = C-");
}
else if (grade >= 67){
  console.log("Your grade = D+");
}
else if (grade >= 63){
  console.log("Your grade = D");
}
else if (grade >= 60){
  console.log("Your grade = D-");
}
else if(grade < 60) 
  console.log("Your grade = F");
