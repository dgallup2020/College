#include <stdio.h>
#include <stdlib.h>

void count1(unsigned int x);

int main(int argc, char *argv[])
{
    if(argc != 2) {
        fprintf(stderr, "Usage: %s <number>\n", argv[0]);
        exit(69);
    }

    unsigned int x;

    x = (unsigned)atoi(argv[1]);

    count1(x);
}

void count1(unsigned int x)
{
    int nbits, i;
    unsigned int bitmask;
    int count, y;

    nbits = sizeof(unsigned int) * 8;
    bitmask = 1;
    count = 0;
    for(i = 0; i < nbits; ++i) {
        if(((bitmask << i) & x)) {
            count++;
        }
    }

    y = 0;
    for(i = 0; i < count; ++i) {
        y |= (bitmask << i);
    }

    printf("%d\n", y);
}
