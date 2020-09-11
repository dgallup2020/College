//dylan gallup: working: 1 | 2 | 9

/*
  Wish list: 
  1. Colors
  2. Trail - path of object leaves a trail 
  3. Other predefined systems (other real solar systems, Jupiter and moons, Earth and moon)
  4. Fix issue with set_initial_v
  5. You name it.
 */
 
 
#include <iostream>
#include <vector>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <curses.h>
#include <math.h>

#include "objects.h"

using namespace std;

int main(int argc, char * argv[]) {
  
  
  if(argc<2){
    printf("Please enter in either [solar_system] or [gliese581]\n");
    exit(0);
  }
  

  world_t w;
  
  w.init_curses();
  
  string input = argv[1];
  //load between two systems
  if(input  == "solar_system")
    w.load_solar_system();
  else if(input == "gliese581")
    w.load_gliese581();
  else
    w.load_solar_system();
  
  //w.load_solar_system();
  //w.load_binary(); w.speed = 3; w.scale *= 2;
  //w.load_gliese581();
  
  int ch = getch();
  while (ch != 'q') {
    mvprintw(3,0,argv[1]);
    // process user input
    w.input(ch);
    
    // move objects tiny little bits, a lot of times
    for(int i=0; i < pow(10,w.speed); i++) {
      // recompute acceleration due to gravity for all objects
      w.compute_g();
      
      // update velocity and position for each object
      w.update();
    }
    w.draw_curses();

    ch = getch();
  }

  // cleanup
  w.end_curses();
  
  return 0;
}
