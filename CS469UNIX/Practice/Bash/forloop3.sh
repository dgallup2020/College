#!/bin/bash

#for loop to iterate from 1 to 30
declare -i e;

for((x=1; x<=10; x++))
do
	let e=($RANDOM%300);
	if((e%2==0));
	then echo "even $x: $e";
	else echo "odd $x: $e";
	fi
	

done
