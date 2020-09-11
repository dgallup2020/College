#!/bin/bash

#for loop to iterate from 1 to 30
for((x=1; x<=20; x++))
do
	if((x%2==0));
	then echo "even $x";
	else echo "odd $x";
	fi
	

done
