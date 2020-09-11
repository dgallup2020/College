#!/bin/bash

#playing around with expansion

let string=1234567890;

echo ${string}
echo ${string:3}
echo ${2:string}
#Doesn't work above
echo ${string[*]}
echo ${string[@]}
echo ${string[$3]}
