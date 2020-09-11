#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<curses.h>

#define NUM_ROWS 10
#define NUM_COLS 10


 char leMaze[NUM_ROWS][NUM_COLS] = {
  "*********\0",
  "*       *\0",
  "* ** ** *\0",
  "* ** ** *\0",
  "* *     *\0",
  "*    ** *\0",
  "* * *** *\0",
  "* * *** *\0",
  "*       *\0",
  "*********\0",
  };


 char keyboard;



 void reDisplay(){
  char s[2000];
  int i;
  
  mvprintw(0,0,"Welcome to the Abyss");
  
  for(i=0; i< NUM_ROWS;i++)
    mvprintw(4+i, 4, "%s",leMaze[i]);

  mvprintw(40, 0, "Press q to quit.");
  
  refresh();
 }
  
  
 int main(int argc, char *argv[]){

  WINDOW * mainwin;
  mainwin = initscr();
  noecho();
  cbreak();
  
  if(mainwin == NULL) { //error statement
    printf("Error initializing screen with ncurses.\n");
    return 0;
  }
  
  reDisplay();
  
  }
