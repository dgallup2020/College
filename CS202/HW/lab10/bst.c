#include "/u1/h0/jkinne/public_html/cs202-f2017/CLASS/DS/bst.h"


/*
  Look for word in BST that starts at root, and return a pointer to node if found.
  If not found, return NULL
 */
bst_node_t *lookup_bst(bst_node_t *root, char *word) {
  if (root == NULL || word == NULL) return NULL;
  bst_node_t *p = root;

  while (p != NULL) {
    int compared = strcmp(word, p->data->w); // word - p->data->w
    if (compared < 0) {      // word is before root->data->w
      p = p->left;
    }
    else if (compared > 0) { // word is after root->data->w
      p = p->right;
    }
    else { // == 0
      return p;
    }
  }

  // p is NULL, not found
  return NULL;
}


/*
  malloc space for a node and initialize
 */
bst_node_t *mk_node_bst() {
  bst_node_t *p = (bst_node_t *) malloc(sizeof(bst_node_t));
  p->data = NULL;
  p->left = p->right = NULL;
  return p;
}



/*
  Make a new word_t thing, and put it into the bst.

  Note: we assume word is not already in the BST.!!
 */
bst_node_t *insert_bst(bst_node_t **root, char *word) {
  // create and init word_t stuff
  word_t *w = mk_word(); // memory for word_t
  init_word(w);          // init word_t
  new_word(w, word);     // put word into word_t

  // create and init our BST node
  bst_node_t *pp = mk_node_bst();  // init a new BST node
  pp->data = w;

  if (*root == NULL) { // first node
    *root = pp;
    return pp;
  }

  // where do we put this word?

  // if here, we know that *root != NULL
  bst_node_t *p = *root, *parent=NULL;
  int onLeft = -1;

  while (p != NULL) {
    parent = p;

    int compared = strcmp(word, p->data->w); // word - p->data->w
    if (compared < 0) {      // word is before root->data->w
      p = p->left; onLeft = 1;
    }
    else if (compared > 0) { // word is after root->data->w
      p = p->right; onLeft = 0;
    }
    else { // == 0
      fprintf(stderr, "Error: insert_bst value already in BST.");
      exit(0);
    }
  }
  
  // p is NULL, and parent is the node we want to insert into
  // insert pp into parent, and onLeft says which side.
  if (onLeft) 
    parent->left = pp;
  else
    parent->right = pp;

  return pp;
}


/*
  print all nodes of the tree, in increasing order alphabetically
  note - this is "traversing" the tree.
 */
void print_bst(bst_node_t *root, FILE *f) {
  if (root == NULL) return;

  // print everything to the left.
  print_bst(root->left, f);

  // print me.
  print_word(root->data, f);

  // print everything to the right.
  print_bst(root->right, f);
}
