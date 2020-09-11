#include "list.h"


/*
  Look for word in list that starts at head, and return a pointer to node if found.
  If not found, return NULL

  running time: n items in list already - O(n)
 */
list_node_t *lookup_list(list_node_t *head, char *word) {
  list_node_t *p;
  
  for(p=head; p != NULL; p = p->next) {
    if (strcmp(word, p->data->w) == 0)
      return p;
  }
  
  return NULL;
}


/*
  malloc space for a node and initialize
 */
list_node_t *mk_node_list() {
  list_node_t *p = (list_node_t *) malloc(sizeof(list_node_t));
  p->data = NULL;
  p->prev = p->next = NULL;
  return p;
}



/*
  Make a new word_t thing, and put it into the list.

  Note: we assume word is not already in the list.!!
 */
list_node_t *insert_list(list_node_t **head, char *word) {
  // create and init word_t stuff
  word_t *w = mk_word(); // memory for word_t
  init_word(w);          // init word_t
  new_word(w, word);     // put word into word_t

  // create and init our list node
  list_node_t *pp = mk_node_list();  // init a new BST node
  pp->data = w;

  if (*head == NULL) { // first node
    *head = pp;
    return pp;
  }

  // where do we put this word?
  // put the new node as head, and if we're here head is already pointing to something
  pp->next = *head;
  (*head)->prev = pp;
  *head = pp;

  return pp;
}


/*
  print all nodes of the tree, in increasing order alphabetically
  note - this is "traversing" the tree.
 */
void print_list(list_node_t *head, FILE *f) {
  list_node_t *p;
  
  for(p=head; p != NULL; p = p->next) {
    // print p
    print_word(p->data, f);
  }
}
