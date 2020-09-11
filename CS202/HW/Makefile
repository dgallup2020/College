CC=gcc

PROGS=lab02_password lab02_countR lab02_countG lab02_miles

# Linux defaults:
CFLAGS=-ggdb -pedantic -Wall
#CFLAGS=-O4 -Wall
LDFLAGS=-s

all:	$(PROGS)

lab02_password:	lab02_password.o
	$(CC) $(LDFLAGS) -o $@ $<

lab02_countR:	lab02_countR.o
	$(CC) $(LDFLAGS) -o $@ $<

lab02_countG:	lab02_countG.o
	$(CC) $(LDFLAGS) -o $@ $<

lab02_miles:	lab02_miles.o
	$(CC) $(LDFLAGS) -o $@ $<

%.o:	%.c
	$(CC) $(CFLAGS) -c -o $@ $<

clean:	objclean
	for b in $(PROGS); do if [ -f "$$b" ]; then rm "$$b"; fi done

objclean:
	for obj in $(PROGS); do if [ -f "$$obj.o" ]; then rm "$$obj.o"; fi done
