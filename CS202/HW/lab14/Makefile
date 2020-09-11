COMPILER=g++
CFLAGS=-ggdb -pedantic -Wall

all:	planets

planets: planets.cpp objects.cpp
	$(COMPILER) $(CFLAGS) objects.cpp planets.cpp -lncurses -o planets
