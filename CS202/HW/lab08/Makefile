COMPILER=gcc
CFLAGS=-ggdb -pedantic -Wall

PROGS=""

all: lab08_1_1 lab08_2_1 lab08_1_5 lab08_2_5 lab08_1_2 lab08_2_2 

lab08_1_1:
	$(COMPILER) $(CFLAGS) lab08_1_1.c -o lab08_1_1

lab08_2_1:
	$(COMPILER) $(CFLAGS) lab08_2_1.c -o lab08_2_1

lab08_1_5:
	$(COMPILER) $(CFLAGS) lab08_1_5.c -o lab08_1_5

lab08_2_5:
	$(COMPILER) $(CFLAGS) lab08_2_5.c -o lab08_2_5

lab08_1_2:
	$(COMPILER) $(CFLAGS) lab08_1_2.c -o lab08_1_2

lab08_2_2:
	$(COMPILER) $(CFLAGS) lab08_2_2.c -o lab08_2_2

clean:	objclean
	for b in $(PROGS); do if [ -f "$$b" ]; then rm "$$b"; fi done

objclean:
	for obj in $(PROGS); do if [ -f "$$obj.o" ]; then rm "$$obj.o"; fi done
