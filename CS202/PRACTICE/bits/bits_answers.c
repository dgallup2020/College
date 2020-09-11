/*
  Some general information / advice

  0. size of integers in C on cs
  char - 1 byte, 8 bits, -128 to 127
  unsigned char - 0 to 255

  short - 2 bytes, 16 bits, -2^15 to 2^15 - 1  (where ^ means exp)
  unsigned short - 0 to 2^16-1 (where ^ means exp)

  int - 4 bytes, 32 bits, 
  unsigned int -

  long - 8 bytes, 64 bits
  unsigned long - 
  
  1. binary
  10101b = 1*16 + 0*8 + 1*4 + 0*2 + 1*1 = 21
  * Note - integers are stored in binary, any integer can be thought of either binary, or decimal, or base 16, ...

  2. hexadecimal (base 16)
  * 16 hex digits - 0 to 9 and a to f, a is 10, b is 11, ..., f is 15
  * 0x12af = 1*16^3 + 2*16^2 + 10*16 + 15*1 = ... (where ^ is exp)
  * 1 hex digit is 4 binary bits, 1111b = 15 = 0xf
  * In C, you use hex by doing
    int x = 0x12f; // 0000 0000 0000 0000  0000 0001 0010 1111
    printf("%x", x);   scanf("%x", &x);

  3. bit operations
  | or.  0x0000000f | 0x000000005 = 0000 1111b
                                  | 0000 0101b
		                    -----------
		                    0000 1111b = 0xf = 15
  & and. 0xf & 0x5 = 1111b & 0101b = 0x0101b = 0x5 = 5
  ^ xor. 0xf ^ 0x5 = 1111b 
                   ^ 0101b
		     ------
		     1010b = 10 = 0xa
  ~ bit flip.  ~ 0x5 = ~ 0x00000005 = 0xfffffffa
  << shift left. 0xf << 4 = 
    |0000 0000 0000 0000  0000 0000 0000 1111b
    |                                        |
0000|0000 0000 0000  0000 0000 0000 1111 0000b

  >> shift right. 0xf >> 4 = 
    |0000 0000 0000 0000  0000 0000 0000 1111b
    |                                        |
    |     0000 0000 0000 0000  0000 0000 0000| 1111b

  * Note: all bit operations are happening on some size'd integer.
          by default, constants in C are int's - 4 bytes, 32 bits.
  * Note: 4 bits is one hex digit, 8 bits is one byte
          >> 4 chops off the right-most hex digit
	  >> 8 chops off the right-most byte
  * Note: integer division by 2 is >> 1, integer mult by 2 is << 1
          integer division by 16 is >> 4, integer mult by 16 is << 4

  4. getting particular bits, hex digits, bytes
     unsigned int x = ...;
     x & 0x00000001 // right-most bit
     x & 0x80000000 // left-most bit, maybe >> 31
     x & 0x00ffff00 // middle two bytes, maybe >> 8
  
  5. binary or hex values of the entire integer
     unsigned int x = ...;
     while (x > 0) { printf("%d", x % 2); x /= 2; } // print in binary in reverse order
     while (x > 0) { printf("%x", (unsigned char) (x % 16)); x /= 16; } // print in binary in reverse order


 */

// oct-30-2017-a
// 30 = 16 + 8 + 4 + 2 = 0000 0000 0000 0000  0000 0000 0001 1110b = 0x0000001d
int howBig(int x) {
  unsigned int m = 0x80000000;
  int bitpos = 31;
  
  for( ; bitpos >= 0; bitpos--) {
    if (x & m != 0) break;
    m = m >> 1;
  }

  return bitpos+1;
}

// oct-30-2017-b
int howBig(int x) {
  if (x & 0xffffff00 == 0) return 1;
  else if (x & 0xffff0000 == 0) return 2;
  else return 4;  
}

// nov-13-2017-a
int justOne(unsigned int x) {
  return ((x & 0x0000ff00) >> 8);
  // (x << 16) >> 24
}

// nov-27-2017-a
int pal(unsigned char c) {
  if ((c & 0x80) >> 7 != c & 0x01) return 0;
  if ((c & 0x40) >> 5 != c & 0x02) return 0;
  if ((c & 0x20) >> 3 != c & 0x04) return 0;
  if ((c & 0x10) >> 1 != c & 0x08) return 0;
  return 1;
  /*
    for(int i=0; i < 4; i++) {
      unsigned char c1, c2;
      c1 = c; c1 <<= 7-i; c1>>= 7;
      c2 = c; c2 <<= i; c2>>= 7;
      if (c1 != c2) return 0;
    }
    return 1;
   */
}

// dec-06-2017-a
void base16(unsigned int x) {
  // 0x12345678
  // 1*16^7 + 2*16^6 + ...  8*16^0(where ^ is exp)
  int pow = 7; unsigned int m = 0xf000000;
  while (pow >= 0) {
    printf("%d * %d", x & m >> (pow*4), (1 << (pow*4)));
    pow--;
    if (pow >= 0) printf(" + " );
    m >>= 4;
  }
}

// dec-06-2017-b
int howMany(unsigned int x) {
  int count = 0;
  if (x & 0x000000ff) count++;
  if (x & 0x0000ff00) count++;
  if (x & 0x00ff0000) count++;
  if (x & 0xff000000) count++;
  return count;
}