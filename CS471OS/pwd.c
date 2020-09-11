#include "types.h"
#include "stat.h"
#include "user.h"
#include "fs.h"

char*
fmtname(char *path)
{
  static char buf[DIRSIZ+1];
  char *p;

  // Find first character after last slash.
  for(p=path+strlen(path); p >= path && *p != '/'; p--)
    ;
  p++;

  // Return blank-padded name.
  if(strlen(p) >= DIRSIZ)
    return p;
  memmove(buf, p, strlen(p));
  memset(buf+strlen(p), ' ', DIRSIZ-strlen(p));
  return buf;
}

void
ls(char *path)
{
  char buf[512], *p;
  int fd;
  struct dirent de;
  struct stat st;

  if((fd = open(path, 0)) < 0){
    printf(2, "ls: cannot open %s\n", path);
    return;
  }

  if(fstat(fd, &st) < 0){
    printf(2, "ls: cannot stat %s\n", path);
    close(fd);
    return;
  }

  switch(st.type){
  case T_FILE:
    printf(1, "%s %d %d %d\n", fmtname(path), st.type, st.ino, st.size);
    break;

  case T_DIR:
    if(strlen(path) + 1 + DIRSIZ + 1 > sizeof buf){
      printf(1, "ls: path too long\n");
      break;
    }
    strcpy(buf, path);
    p = buf+strlen(buf);
    *p++ = '/';
    while(read(fd, &de, sizeof(de)) == sizeof(de)){
      if(de.inum == 0)
        continue;
      memmove(p, de.name, DIRSIZ);
      p[DIRSIZ] = 0;
      if(stat(buf, &st) < 0){
        printf(1, "ls: cannot stat %s\n", buf);
        continue;
      }
      printf(1, "%s %d %d %d\n", fmtname(buf), st.type, st.ino, st.size);
    }
    break;
  }
  close(fd);
}

int
main(int argc, char *argv[])
{
printf(1, "%s\n",argv[0]);
printf(1, " pwd: A - hello from pwd!\n");

char buf[512], *p, *dirname;
int fd;


struct stat st, st_parent, temp;
struct dirent de;
//part B

stat(".",&st);
stat("..",&st_parent);
printf(1, " pwd: B - inode of current directory: %d\n", st.ino);
printf(1, " pwd: B - inode of parent directory: %d\n", st_parent.ino);

if(st.ino == st_parent.ino)
	printf(1, " pwd: C - parent=current, so we're at /\n");
else
	printf(1, " pwd: C - parent!=current, so we're not at /\n");




fd = open("..",0); //same as read only 0x000

strcpy(buf,"..");
p = buf+strlen(buf);
*p++ = '/';
while(read(fd, &de, sizeof(de)) == sizeof(de)){
	memmove(p,de.name, DIRSIZ);
	p[DIRSIZ] = 0;
	stat(buf, &temp);
	if(st.ino == temp.ino){
		dirname = de.name;
		break;
	}
}

//we have not found hte same inode

printf(1, "   pwd: D - name of current working directory: %s\n",dirname); 


return 0;	
/*
  int i;

  if(argc < 2){
    ls(".");
    exit();
  }
  for(i=1; i<argc; i++)
    ls(argv[i]);
  exit();
*/
}
