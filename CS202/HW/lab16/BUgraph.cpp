
#include <queue>
#include "graph.h"

using namespace std;

Vertex::Vertex() {
  label = "";
  initAlg();
}

void Vertex::initAlg() {
  parent = NULL;
  dist = -1;
}

Edge::Edge() {
  src = dest = NULL;
  weight = 1;
}

Graph::Graph() {
  n = 0;
}

// print information about valid file formats
void Graph::fileFormats() {
  cout << "n\n"
    "directed|undirected\n"
    "weighted|unweighted\n"
    "label1\n"
    "label2\n"
    "...\n"
    "labeln\n"
    "label_src1 label_dest1 [weight1]\n"
    "label_src2 label_dest2 [weight2]\n"
    "# end of file can have commented lines starting with #\n"
       << endl;
}

void Graph::open(string fileName) {
  ifstream f_in;
  f_in.open(fileName.c_str());
  // check for error

  string s;

  // read in metadata
  f_in >> n;
  f_in >> s; directed = (s == "directed");
  f_in >> s; weighted = (s == "weighted");

  // read in labels
  for(int i=0; i < n; i++) {
    f_in >> s;
    Vertex v; v.label = s;
    V.push_back(v);
  }

  // read in edges
  string src, dest; int w;
  while (f_in >> src >> dest) {
    if (src[0] == '#' ) break; // comment lines after edges
    
    if (weighted) f_in >> w;

    Edge e; e.weight = w;
    e.src = lookupV(src);
    e.dest = lookupV(dest);

    if (e.src != NULL && e.dest != NULL)
      E.push_back(e);
    else
      cerr << "Error in graph adjacency list, vertex label not found." << endl;
  }
}

// return pointer to first vertex with label matching parameter
Vertex *Graph::lookupV(string label) {
  for(int i=0; i < V.size(); i++) {
    if (V[i].label == label) return &(V[i]);
  }
  return NULL;
}

void Graph::printAdjList() {
  cout << "n: " << n << endl;
  cout << "   " << (weighted ? "weighted" : "unweighted") << endl;
  cout << "   " << (directed ? "directed" : "undirected") << endl;

  // print vertex labels
  cout << "V: ";
  for(int i=0; i < V.size(); i++) {
    cout << V[i].label;
    if (V[i].parent != NULL) 
      cout << "[<-" << V[i].parent->label << "," << V[i].dist << "]";
    cout << " ";
  }
  cout << endl;

  // print edge
  cout << "E: " << endl;
  for(int i=0; i < E.size(); i++) {
    if (E[i].src == NULL || E[i].dest == NULL) continue;
    cout << "   (" << E[i].src->label;
    if (directed) cout << "-> "; else cout << ", ";
    cout << E[i].dest->label;
    if (weighted) cout << ", " << E[i].weight;
    cout << ")" << endl;
  }
}

void Graph::initAlg() {
  for(int i=0; i < V.size(); i++) {
    V[i].initAlg();
  }
}


void Graph::degreeStats(){
/*
for each vertex 
  if(edge -> source == v parent) then deg + 1
  else if (not directed && edge -> dest) deg +1
  */
  int degrees;
  cout << "degrees -\n";

  for(int i= 0; i < V.size(); i++){
    degrees = 0;
    for(int j = 0; j < E.size(); j++){
      if(V[i].parent == E[j].src)
	        degrees++;
	    else if(!directed && (V[i].parent == E[j].dest))
	    //else if(V[i].parent == E[j].dest)
	        degrees++;
	    cout << degrees << endl;
	    cout << E[j].src->label << " , " << E[j].dest->label << endl; 
    }
    cout << "deg(" << V[i].label << ") = " << degrees << endl;
  }
}
/*
current troubleshooting:
counts for b,c,d are actually the counts for e,f,g
printed the edges and confirmed
how to fix, idk
maybe have something to do with the counts or order of the check. 
*/

void Graph::BFS(string start) {

  initAlg();  // init all parents to NULL, all dist to 0

  // start vertex
  Vertex *s = lookupV(start);
  if (s == NULL) return;
  s->parent = s; s->dist = 0;

  // Frontier is queue
  queue<Vertex *> frontier;

  frontier.push(s);

  // remove a vertex from frontier, check its neighbors, repeat
  while (! frontier.empty()) {
    Vertex * v = frontier.front();  frontier.pop();

    for(int i=0; i < E.size(); i++) {
      Vertex *u = NULL;
      if (E[i].src == v) u = E[i].dest;
      else if (E[i].dest == v) u = E[i].src;
      if (u != NULL) {
	if (u->parent == NULL) {
	  u->parent = v;
	  u->dist = v->dist + 1;
	  frontier.push(u);
	}
      }
    }
  }
}
