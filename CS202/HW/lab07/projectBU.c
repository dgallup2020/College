

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include <curses.h>

//WORKING VERSION WITH PLAYER STRUCTURE

// location - two coordinates, row and column, integers
// the map  - strings for each row of the screen
// monsters
// etc.

//char s[100] = "hello";

// note: we need to put the \0 in ourselves when we have
// an array of strings."
#define NUM_ROWS 8
char myMaze[NUM_ROWS][11] = {
  "**********\0",  // myMaze[0]
  "*        *\0",  // myMaze[1]
  "* ** *** *\0",
  "*    *   *\0",
  "**** *** *\0",
  "*        ~\0",
  "* $      *\0",
  "**********\0",  // myMaze[7]
};

/*
  Reading maze from file.
  0. Read from file and print on screen.
  1. Enforce rule that the dimensions in the file are same as this.
     You can getline into myMaze[i] for row i
  2. User option to choose which maze - by command-line argument.
 */

//int myRow=1, myColumn=1;

struct player {
  int row;
  int col;
  int health;
  int score;
  char* sprite;
  int strength;
  // display character
  // strength
};
// M has strength 10
// m has strength 5



char chTyped;
//int health = 100;
//int score = 0; 


void reDisplay(struct player p, struct player m1) {
  char s[1000];
  int i;

  // mvprintw is like printf but you tell it where on the screen to print - 
  // which row and column.
  mvprintw(0,0,"Maze of doom..."); 

  // prints the maze
  for(i=0; i < NUM_ROWS; i++)
    mvprintw(2+i, 0, "%s", myMaze[i]);

  // print me.
  
  mvprintw(2 + p.row, p.col, p.sprite);
  mvprintw(2 + m1.row, m1.col,m1.sprite);
  

  mvprintw(20, 0, "Press q to quit.");

  mvprintw(21, 0, "Character just typed: %d", chTyped);
  
  mvprintw(25, 0, "YOUR SCORE = %d",p.score);
  mvprintw(27, 0, "PLAYER 1 HEALTH = %d ",p.health);
  
  
  mvprintw(28, 0, "MONSTER 1 ------ HEALTH = %d ",m1.health);
  

  if(p.health==0)
    mvprintw(29, 0,"-------GAME OVER-------");
  
  refresh(); // make it redisplay based on what we've done.
}
//player movement
struct player movement(char in, struct player tp){
    if(in == 'w' && (myMaze[tp.row-1][tp.col] == ' ')) (tp.row)--;
    if(in == 's' && (myMaze[tp.row+1][tp.col] == ' ')) (tp.row)++;
    if(in == 'a' && (myMaze[tp.row][tp.col-1] == ' ')) (tp.col)--; 
    if(in == 'd' && (myMaze[tp.row][tp.col+1] == ' ')) (tp.col)++; 

  return tp;
}
//player score increase
struct player sc(char in, struct player tmp){
  if(in == 'w' && myMaze[tmp.row-1][tmp.col] == '$') tmp.score+=100;
  if(in == 's' && myMaze[tmp.row+1][tmp.col] == '$') tmp.score+=100;
  if(in == 'a' && myMaze[tmp.row][tmp.col-1] == '$') tmp.score+=100;
  if(in == 'd' && myMaze[tmp.row][tmp.col+1] == '$') tmp.score+=100;
  return tmp;
}

struct player heal_dc(char in, struct player tmp, struct player m1){
  if(tmp.col == m1.col && tmp.row == m1.row) tmp.health -= 10;
  
  /*
  if(in == 'w' && (myMaze[tmp.row-1][tmp.col] == 'M')) tmp.health-=10; 
  if(in == 's' && (myMaze[tmp.row+1][tmp.col] == 'M')) tmp.health-=10;
  if(in == 'a' && (myMaze[tmp.row][tmp.col-1] == 'M')) tmp.health-=10;
  if(in == 'd' && (myMaze[tmp.row][tmp.col+1] == 'M')) tmp.health-=10;
  return tmp;
  */
  return tmp;
}

struct player battle(struct player p, struct player mon){
    
    int pAttack = p.strength * ((rand() % 6 + 1) + (rand() % 6 + 1));
    int monAttack = mon.strength * ((rand() % 6 + 1) + (rand() % 6 + 1)); 
    struct player result = p;
    
    
    if(pAttack >= monAttack)
      result.health -= 10;
    
    else{
      result = mon;
      result.health -= 10;
    }
    
    return result;
  
}




int main(int argc, char *argv[]) {

  WINDOW * mainwin;
  mainwin = initscr(); // create the screen  
  noecho(); // don't display characters that are typed
  cbreak(); // don't wait for enter key for us to get characters

  if (mainwin == NULL) { // if there was an error
    printf("Error initializing screen with ncurses.\n");
    return 0;
  }
  
  struct player p1;
  p1.row = 1;
  p1.col = 1;
  p1.score = 0;
  p1.health = 100;
  p1.sprite = "@";
  
  
  
  struct player m1;
  m1.row = 6;
  m1.col = 4;
  m1.health = 50;
  m1.sprite = "M";

  // got stuff setup, so now display the screen.
  reDisplay(p1,m1);

  // now just read a character at a time until they want to quit.
  //scanf("%c",&ch); note: can use scanf if you want
  chTyped = getchar();
  while (chTyped != 'q') {
    // check if they place they're trying to go to is...
    // if M, then fight monster
    // if $, then collect gold
    
    
    
  if(p1.health>0){ //character goes through MONSTER because of order in comparision???)
      p1 = movement(chTyped, p1);
      p1 = sc(chTyped, p1);
      if(p1.row == m1.row && m1.col == p1.col){
	if(m1.health>0){
	  struct player result = battle(p1,m1);
	  if(result.sprite[0] == 'M')
	    m1 = result;
	  else
	    p1 = result;
	}
      }
      
      //p1 = heal_dc(chTyped, p1,m1);
  }
    
    
    
    
    
    reDisplay(p1,m1);
    //scanf("%c",&ch);
    chTyped = getchar();
  }


  // before we quit, clean up the screen...  we'll leave it 
  // blank and nice.
  delwin(mainwin);
  endwin();
  refresh();
  return 0;
}
