#!/bin/bash

# Make a script that when given a base user-name (e.g. cs469) and a count on
# the command line, print out a /etc/passwd entry for the count number of class
# accounts.  It should allow additional command line parameters to set the
# 1) starting uid (default=1000), 2) group id/name (default = class),
# 3) base home directory (default=/u1/class), 4) shell (default = /bin/tcsh)
# The password field entry should be a random password composed of 6 letters.
# If not enough parameters are provided it should print a usage message and
# exit.
# Example:
# > ./c.sh
# Usage: ./c.sh <base> <count> [<start uid> [<group> [<base home> [<shell]]]]
# > ./c.sh cs469 3
# cs46900:rzkuey:1000:class::/u1/class/cs46900:/bin/tcsh
# cs46901:icqfah:1001:class::/u1/class/cs46901:/bin/tcsh
# cs46902:xwbbhg:1002:class::/u1/class/cs46902:/bin/tcsh
# >./c.sh cs469 2 2000 users /u1/h7 /bin/bash
# cs46900:fsokff:2000:users::/u1/h7/cs46900:/bin/bash
# cs46901:mgngyv:2001:users::/u1/h7/cs46901:/bin/bash

