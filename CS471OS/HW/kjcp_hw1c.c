/*
  Author:   Jeff Kinne
  Date:     August 23, 2018
  Contents: program to copy a file, practice using C using system calls!
 */
#include <unistd.h>
#include <string.h>
#include <stdlib.h>
#include <fcntl.h>

int main(int argc, char *argv[]) {
  char * msg;
  if (argc < 3) { // 
    msg = "Usage: ./cp471 src dest\n";
    write(1, msg, sizeof(char) * strlen(msg)); // 1 means stdout
    // note that write is a system call, goes directly to unix kernel.
    // fprintf is a library function, which uses write
    exit(0);
  }

  int src = open(argv[1], O_RDONLY);
  if (src == -1) {
    msg = "Error opening file for reading\n";
    write(1, msg, sizeof(char) * strlen(msg));
    exit(0);
  }

  // note: open is a unix system call, fopen is not.
  int dest = open(argv[2], O_WRONLY | O_CREAT | O_TRUNC, S_IRWXU);
  if (dest == -1) {
    msg = "Error opening file for writing\n";
    write(1, msg, sizeof(char) * strlen(msg));
    exit(0);
  }

  // now loop through the src file, read bytes from it, write them to dest
  
  ssize_t count;
  unsigned char ch;
  do {
    count = read(src, &ch, sizeof(unsigned char));
    write(dest, &ch, count);
  } while (count > 0);

  close(src);
  close(dest);
  return 0;
}
