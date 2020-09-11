// ISU-f2018 exam1

#include "types.h"
#include "stat.h"
#include "user.h"
#include "fcntl.h"
#include "traps.h"

int
main(int argc, char *argv[])
{
  if(argc < 2){
    printf(2, "Program to test how many memory ops vs disk ops it takes for a number of ticks to elapse.\n");
    printf(2, "Usage: ./timing numTicks\n");
    exit();
  }
  int numTicks = atoi(argv[1]);

  uint start_ticks = uptime();

  int y = 0;
  while (uptime() - start_ticks < numTicks) {
    y++;
  }
  printf(1,"%d memory operations\n", y);

  uint middle_ticks = uptime();
  
  int z = 0;
  while (uptime() - middle_ticks < numTicks) {
    int f = open("nothing.txt", O_WRONLY | O_CREATE);
    write(f, "hello", 5);
    close(f);
    z++;
  }
  printf(1,"%d disk operations\n", z);

  struct trap_counts t;
  ticks(&t);
  printf(1, "Trap/interrupt counts... %d syscall, %d timer, %d kbd, %d com1, %d ide, %d error, %d spurious\n",
         t.syscall, t.timer, t.kbd, t.com1, t.ide, t.error, t.spurious);
  
  exit();
}
