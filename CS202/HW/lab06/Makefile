COMPILER=gcc
CFLAGS=-ggdb -pedantic -Wall

PROGS=""

all: lab06_simple1 lab06_simple2 lab06_simple3 lab06_simple4

lab06_simple1:
	$(COMPILER) $(CFLAGS) /u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.c lab06_simple1.c -o lab06_simple1

lab06_simple2:
	$(COMPILER) $(CFLAGS) /u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.c lab06_simple2.c -o lab06_simple2

lab06_simple3:
	$(COMPILER) $(CFLAGS) /u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.c lab06_simple3.c -o lab06_simple3

lab06_simple4:
	$(COMPILER) $(CFLAGS) /u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/words.c lab06_simple4.c -o lab06_simple4

clean:	objclean
	for b in $(PROGS); do if [ -f "$$b" ]; then rm "$$b"; fi done

objclean:
	for obj in $(PROGS); do if [ -f "$$obj.o" ]; then rm "$$obj.o"; fi done
