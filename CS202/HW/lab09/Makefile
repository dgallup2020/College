COMPILER=gcc
CFLAGS=-ggdb -pedantic -Wall

PROGS=""

all: lab09_1 lab09_2 lab09_3 lab09_4

lab09_1:
	$(COMPILER) $(CFLAGS) lab09_1.c -o lab09_1

lab09_2:
	$(COMPILER) $(CFLAGS) lab09_2.c -o lab09_2

lab09_3:
	$(COMPILER) $(CFLAGS) lab09_3.c -o lab09_3

lab09_4:
	$(COMPILER) $(CFLAGS) lab09_4.c -o lab09_4


clean:	objclean
	for b in $(PROGS); do if [ -f "$$b" ]; then rm "$$b"; fi done

objclean:
	for obj in $(PROGS); do if [ -f "$$obj.o" ]; then rm "$$obj.o"; fi done
