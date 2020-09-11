#include<stdio.h>

//number of arguments and an array that contains one pointer to each 
//string
int main(int argc, char *args[])
{
  if (argc<2) {
    printf("Not enough arguments\n");
    return 0;
  }
  FILE *fi = fopen(args[1], "r");
  FILE *fo = fopen(args[2], "w");
  int c;
  //while (get a value from fi in variable c, and if its not EOF)
  while (   (c = getc(fi)) != EOF  )
    putc(c,fo);
  fclose(fi);
  fclose(fo);

}
