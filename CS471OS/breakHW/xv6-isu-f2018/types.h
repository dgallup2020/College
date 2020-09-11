typedef unsigned int   uint;
typedef unsigned short ushort;
typedef unsigned char  uchar;
typedef uint pde_t;

// ISU-f2018 exam1
struct trap_counts {
  int syscall;
  int timer;
  int kbd;
  int com1;
  int ide;
  int error;
  int spurious;
};
