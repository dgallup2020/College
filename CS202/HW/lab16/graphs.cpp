/*
  To compile: g++ graph.cpp graphs.cpp -o g
 */

#include <fstream>
#include <stdlib.h>
#include "graph.h"

using namespace std;

int main(int argc, char *argv[]) {

  if (argc < 2) {
    cout << "Usage: ./a.out graphFile.txt" << endl;
    cout << "  File format - " << endl;
    Graph::fileFormats();
    exit(0);
  }
  
  Graph G;
  G.open(argv[1]);

  if (G.V.size() > 0)
    G.BFS(G.V[0].label);
  
  G.printAdjList();
  G.degreeStats();
  bool cCheck;
  cCheck = G.connectedCheck();
  if(cCheck)
    cout << "the graph is connected\n";
  else
    cout << "the graph is NOT connected\n";
  G.maxDistance();  
  
  return 0;
}


