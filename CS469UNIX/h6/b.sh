#!/bin/bash

# Using the output of find given a path from the command line (or . as a
# default,) find the largest (regular) file and print its size (in bytes) with
# its name.  Hint: Use < <(find ...) into a while loop to read the paths from 
# find in the shells current context.
# Also this could be done with a single pipeline.
# Example:
# > ./b.sh /var/log
#        27705680: /var/log/messages

