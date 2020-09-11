#ifndef OBJECTS_H_
#define OBJECTS_H_

#include <iostream>
#include <vector>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <curses.h>
#include <math.h>

using namespace std;


class point_t {
public:
  double x, y;

  point_t();

  double dist(const point_t & p);

  double dist(); // distance from 0,0
};

class object_t {
public:
  double mass;
  point_t pos, vel, acc;
  char display;

  // constructor, happens when instance of the class is created
  object_t(double x, double y, char ch, double m);
};


/*
  Units and stuff ...
  * screen is roughly 80 x 25 characters
  * timestep will be 1 second
  * so velocity, acceleration should be around 1 char/second
 */


class world_t {
public:
  vector<object_t> stuff; // planets, etc.
  WINDOW * mainwin;   // for curses drawing

  int speed;          // speed of simulation
  double timeStep;    // each time step is this many seconds
  
  double scale;       // 1 character = scale many km
  
  double mass;        // total mass
  point_t center;     // center of mass

  double  G;          

  world_t();            // constructor

  void input(char ch);  // handle user input
  
  void init_curses();   // get screen ready for curses drawing
  void end_curses();    // stop curses stuff

  void add_object(double x, double y, char ch, double m); // create a new object and put it in the stuff vector

  void compute_g();     // recompute strength of gravity for all objects

  void update();        // uses gravity for each object to update velocity, and then also position
  
  void draw_curses();   // redraws screen

  void load_solar_system();
  
  void load_gliese581();
  
  void load_binary();

  void set_initial_v();

  void center_of_mass();

  void set_scale();

};




#endif