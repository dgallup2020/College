#include <stdio.h>
#include <stdlib.h>

void specialPrint(unsigned int x);

int main(int argc, char *argv[])
{
    if(argc != 2) {
        fprintf(stderr, "Usage: %s <number>\n", argv[0]);
        exit(69);
    }

    unsigned int x;

    x = (unsigned)atoi(argv[1]);

    specialPrint(x);
}

void specialPrint(unsigned int x)
{
    int i;
    unsigned int bitmask;

    bitmask = 1 << 31;

    while(bitmask && !(bitmask & x)) {
        bitmask >>= 1;
    }

    while(bitmask) {
        if((bitmask & x)) {
            printf("*");
        } else {
            printf("-");
        }
        bitmask >>= 1;
    }
    printf("\n");
}
