#include <iostream>
#include <vector>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <curses.h>
#include <math.h>


#include "objects.h"

point_t::point_t() {
  x = y = 0.0;
}

// return distance from point to another point
double point_t::dist(const point_t & p) {
  return sqrt((p.x-x)*(p.x-x) + (p.y-y)*(p.y-y));
}

// return distance from point to 0,0
double point_t::dist() {
  return sqrt(x*x + y*y);
}

object_t::object_t(double x, double y, char ch, double m) {
  mass = m; display = ch;
  pos.x = x; pos.y = y;
}


/*
  Units and stuff ...
  * screen is roughly 80 x 25 characters
  * timestep will be 1 second
  * so velocity, acceleration should be around 1 char/second
 */

world_t::world_t() {
  speed = 5; // how fast to redraw

  // # seconds per time step, so 1 earth year is something like 20 seconds
  timeStep = (double) 60*60*24*365 / 20.0 / CLOCKS_PER_SEC;
  
  scale = 1.0;
  G = 1.0;
  mass = 0.0;
}


void world_t::init_curses() {
  mainwin = initscr(); // create the screen  
  noecho(); // don't display characters that are typed
  cbreak(); // don't wait for enter key for us to get characters
  halfdelay(1); // make getch return after 1/10 of a second, even if no character typed
  
  if (mainwin == NULL) { // if there was an error
    printf("Error initializing screen with ncurses.\n");
    exit(0);
  }
}

void world_t::end_curses() {
  // before we quit, clean up the screen...  we'll leave it 
  // blank and nice.
  delwin(mainwin);
  endwin();
  refresh();  
}

void world_t::add_object(double x, double y, char ch, double m) {
  object_t o(x,y,ch,m);
  stuff.push_back(o);
}

void world_t::compute_g() {
  // note: running time of this is O(k squared) where k is # of objects
  for(uint i=0; i < stuff.size(); i++) {
    // do gravity calculation for every other object pulling stuff[i]
    stuff[i].acc.x = stuff[i].acc.y = 0; 
    for(uint j=0; j < stuff.size(); j++) {
      if (i == j) continue;
      double a, d;
      d = stuff[i].pos.dist(stuff[j].pos); // distance between object i, j
      a = G * stuff[j].mass / (d*d);       // magnitude of acceleration
      
      stuff[i].acc.x += a * (stuff[j].pos.x-stuff[i].pos.x)/d; // x component of acceleration
      stuff[i].acc.y += a * (stuff[j].pos.y-stuff[i].pos.y)/d;
    }
  }
}

void world_t::update() {
  for(uint i=0; i < stuff.size(); i++) {
    // update velocity
    stuff[i].vel.x += stuff[i].acc.x * timeStep; 
    stuff[i].vel.y += stuff[i].acc.y * timeStep;
    
    // update position
    stuff[i].pos.x += stuff[i].vel.x * timeStep;
    stuff[i].pos.y += stuff[i].vel.y * timeStep;

  }
}

void world_t::draw_curses() {
  clear(); // curses function, clear the screen
  
  for(uint i=0; i < stuff.size(); i++) {
    uint row = 12 - (int) (stuff[i].pos.y/scale),
      col = (int) (stuff[i].pos.x/scale) + 40;
    char ch = stuff[i].display;

    // note: for mvprintw, row is 0 at top and larger going down, col is 0 at left, larger going right
    mvprintw(row, col, "%c", ch); // print at position row, col on screen    
  }

  mvprintw(0,0, "(q)uit  speed: %d (+)/(-)   zoom: (<)(>)", speed);
  mvprintw(1,0, "(p)ause / (p)lay");
  
  refresh(); // curses function, redraw
}

void world_t::input(char ch) {
  if (ch == '+') {
    speed++;
  }
  else if (ch == '-') {
    speed--;
  }
  else if (ch == '<') {
    scale *= 2;
  }
  else if (ch == '>') {
    scale /= 2;
  }
  //pause condition
  else if (ch == 'p') {
    bool stop = 0;
    int pause = 'a';
    while(stop == 0){
      if(pause == 'p' || pause == 'q')
        stop = 1;
      pause = getch();
    }
  }
}

/*
  For doing solar system.  See https://nssdc.gsfc.nasa.gov/planetary/factsheet/
  Object: mass (kg), mean dist from sun (km)

  Sun:     1.98855e30, 0
  Mercury: 0.330e24, 57.9e6
  Venus:   4.87e24, 108.2e6
  Earth:   5.97e24, 149.6e6
  Mars:    0.642e24, 227.9e6
  Jupiter: 1898e24, 778.6e6
  Saturn:  568e24, 1433.5e6
  Uranus:  86.8e24, 2872.5e6
  Neptune: 102e24, 4495.1e6
  Pluto:   0.0146e24, 5906.4e6
 */
void world_t::load_solar_system() {
  
  add_object(0,0,'S',1.98855e30); // units: km, kg
  add_object(57.9e6,0, 'm', 0.330e24);
  add_object(0,108.2e6, 'V', 4.87e24);
  add_object(-149.6e6,0, 'E', 5.97e24);
  add_object(0,-227.9e6, 'M', 0.642e24);
  /*
  add_object(778.6e6,0, 'J', 1898e24);
  add_object(0,1433.5e6, 's', 568e24);
  add_object(-2872.5e6,0, 'U', 86.8e24);
  add_object(0,-4495.1e6, 'N', 102e24);
  add_object(5906.4e6,0, 'p', 0.0146e24);
*/
  // see: Newton's law of gravitation
  G = 6.67408e-20 ; // km^3 /kg / s^2

  set_initial_v();

  set_scale();
}

/*
 *   e - 8, bold
     b - yellow
     c - blue
     g - red, bold
     d - red
 * 	 note: an AU is the distance from the earth to the sun is about 150e6 km
 */


void world_t::load_gliese581(){
  
  //double AU = 149.6e6;
  
  add_object(0,0,'S',((1.99e30)*.31));
  add_object((149.6e6)*(0.02815),0,'e',((5.9722e24)*1.7));
  add_object(0,((149.6e6)*(0.04061)),'b',((5.9722e24)*15.8));
  add_object(-(149.6e6)*(0.0721),0,'c',((5.9722e24)*5.5));
  add_object(0,-(149.6e6)*(0.13),'g',((5.9722e24)*2.2));
  add_object((149.6e6)*(0.21847),0,'d',((5.9722e24)*6.98));
  
  G = 6.67408e-20 ; 
  
  set_initial_v();

  set_scale();
  
}


void world_t::load_binary() {
  
  add_object(57.9e6,0,'S',1.98855e30); // units: km, kg
  add_object(-57.9e6,0,'s',1.98855e30); // units: km, kg

  // see: Newton's law of gravitation
  G = 6.67408e-20 ; // km^3 /kg / s^2

  set_initial_v();

  set_scale();
}

// set initial velocities on objects to be counter-clockwise and
// enough to stay in orbit.
void world_t::set_initial_v() {
  // calculate center of mass of the whole system
  center_of_mass();

  for(uint i=1; i < stuff.size(); i++) {
    // acceleration due to gravity to the center of mass
    double g, d;
    d = stuff[i].pos.dist(center); // distance between object i, j
    g = G * mass / (d*d);         // magnitude of acceleration
    
    // required centripetal acceleration to offset gravity is v^2/d
    // v^2/d = g, so v = sqrt(g*d) and needs to be orthogonal to g
    double v = sqrt(g*d);

    stuff[i].vel.x = v * (center.y - stuff[i].pos.y)/d;
    stuff[i].vel.y = v * -1 * (center.x - stuff[i].pos.x)/d;
  }
}

// return center of mass of the system
void world_t::center_of_mass() {
  mass = 0;
  center.x = 0; center.y = 0;
  for(uint i=0; i < stuff.size(); i++) {
    mass += stuff[i].mass; 
  }
  for(uint i=0; i < stuff.size(); i++) {
    center.x += stuff[i].pos.x * stuff[i].mass / mass;
    center.y += stuff[i].pos.y * stuff[i].mass / mass;
  }
}

// set scale so all objects are visible on the screen
void world_t::set_scale() {
  double max = 0.0; // will be maximum distance from 0,0
  for(uint i=0; i < stuff.size(); i++) {
    if (stuff[i].pos.dist() > max) max = stuff[i].pos.dist();
  }

  scale = max / 40.0;
}
