CC=gcc

PROGS=lab04_quiz1 lab04_caesar1 lab04_caesar2

# Linux defaults:
CFLAGS=-ggdb -pedantic -Wall
#CFLAGS=-O4 -Wall
LDFLAGS=-s

all:	$(PROGS)

lab04_quiz1:	lab04_quiz1.o
	$(CC) $(LDFLAGS) -o $@ $<

lab04_caesar1:	lab04_caesar1.o
	$(CC) $(LDFLAGS) -o $@ $<

lab04_caesar2:	lab04_caesar2.o
	$(CC) $(LDFLAGS) -o $@ $<

%.o:	%.c
	$(CC) $(CFLAGS) -c -o $@ $<

clean:	objclean
	for b in $(PROGS); do if [ -f "$$b" ]; then rm "$$b"; fi done

objclean:
	for obj in $(PROGS); do if [ -f "$$obj.o" ]; then rm "$$obj.o"; fi done
