#!/bin/bash
for argc in "$#";
do
	echo "number of args" $argc;
done;

for argv in "$@";
do
	echo "argv: "  $argv;
done

for file in *;
do
	echo "file: " $file;
done
