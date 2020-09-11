CC=gcc

PROGS=lab03_count lab03_miles lab03_tower lab03_password lab03_arith

# Linux defaults:
CFLAGS=-ggdb -pedantic -Wall
#CFLAGS=-O4 -Wall
LDFLAGS=-s

all:	$(PROGS)

lab03_count:	lab03_count.o
	$(CC) $(LDFLAGS) -o $@ $<

lab03_miles:	lab03_miles.o
	$(CC) $(LDFLAGS) -o $@ $<

lab03_tower:	lab03_tower.o
	$(CC) $(LDFLAGS) -o $@ $<

lab03_password:	lab03_password.o
	$(CC) $(LDFLAGS) -o $@ $<

lab03_arith:	lab03_arith.o
	$(CC) $(LDFLAGS) -o $@ $<

%.o:	%.c
	$(CC) $(CFLAGS) -c -o $@ $<

clean:	objclean
	for b in $(PROGS); do if [ -f "$$b" ]; then rm "$$b"; fi done

objclean:
	for obj in $(PROGS); do if [ -f "$$obj.o" ]; then rm "$$obj.o"; fi done
