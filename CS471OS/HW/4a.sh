#!/bin/bash

# how much is free to start with
free -h

# run the program with 2GB
./a.out 2000 &

# print free information, once per second, 10 times
free -h -s 1 -c 10

# kill the ./a.out
kill $!

# wait a little bit
sleep 3

# and now how much does free report
free -h