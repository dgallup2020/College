#ifndef GRAPH_H_
#define GRAPH_H_

#include <vector>
#include <fstream>
#include <iostream>

using namespace std;

class Vertex {
 public:
  string label;
  Vertex *parent;
  int dist;

  Vertex(); // constructor

  void initAlg(); // initialize values before algorithm run
};

class Edge {
 public:
  Vertex *src, *dest;
  int weight;

  Edge(); // constructor
};

class Graph {
 public:
  unsigned int n; // # of vertices
  bool weighted, directed;
  vector<Vertex> V; // array of vertices
  vector<Edge> E;   // array of edges

  Graph(); // constructor
  
  void open(string fileName); // constructor
  void printAdjList();
  static void fileFormats();
  
  // helper
  Vertex * lookupV(string label);
  
  void degreeStats();

  bool connectedCheck();

  void initAlg(); // initialize values before algorithm run
  void BFS(string start);     // 
  bool cBFS(string start);
  void maxDistance();
};


#endif
