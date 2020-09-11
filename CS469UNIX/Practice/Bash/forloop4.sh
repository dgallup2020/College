#!/bin/bash

for file in *
do
	if [[ -f "$file" ]]; then 
	echo ">>Regular File $file <<";
	fi
	if [[ -r "$file" ]]; then
	echo ">>	Readable $file <<";	
	fi
done

DIR=*
echo $DIR;
echo ${#DIR[*]}
