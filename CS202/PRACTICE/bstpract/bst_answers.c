// note: a few pictures are in https://docs.google.com/presentation/d/1flawO-ScOZOuxJj7-iJnB59VoWE2y5EEnwbkAFuH6AM/edit?usp=sharing
// this file is in /u1/junk/ProgrammingAssessment

// nov-13-2017-a #4

int total(bst_node_t *root) {
  // base case
  if (root == NULL) return 0;
  
  // do something with root->data
  int count = 0;
  if (root->left != NULL && root->right != NULL)
    count++;

  // answer from the children
  int countLeft = total(root->left);
  int countRight = total(root->right);

  // put together
  return count + countLeft + countRight;
}
// in main
int x = total(root);


// nov-13-2017-b
int total(bst_node_t *root) {
  // base case
  if (root == NULL) return 0;
  
  // do something with root->data
  int count = 0;
  if (root->left == NULL && root->right != NULL ||
      root->left != NULL && root->right == NULL)
    count++;

  // answer from the children
  int countLeft = total(root->left);
  int countRight = total(root->right);

  // put together
  return count + countLeft + countRight;
}
// aside or note: root->left is shorthand for (*root).
//                if root is NULL, root-> is (*NULL).


// oct-30-2017-a
int total(bst_node_t *root) {
  // base case
  if (root == NULL) return 0;
  
  // do something with root->data
  int count = 0;
  if (root->word != NULL)
    count++;

  // answer from the children
  int countLeft = total(root->left);
  int countRight = total(root->right);

  // put together
  return count + countLeft + countRight;
}


// oct-30-2017-b
int total(bst_node_t *root) {
  // base case
  if (root == NULL) return 0;
  
  // do something with root->data
  int count = 0;
  if (root->word != NULL)
    count = strlen(root->word);

  // answer from the children
  int countLeft = total(root->left);
  int countRight = total(root->right);

  // put together
  return count + countLeft + countRight;
}


// nov-27-2017-a
void smallerPrint(bst_node_t *root, int value) {
  // base case
  if (root == NULL) return;
  
  // 1. do something with root->data
  if (root->data < value)
    printf("%d\n", root->data);

  // the children
  total(root->left);  // 2. 
  total(root->right); // 3.
}
// in main
smallerPrint(root, 40);
// what order to do 1, 2, 3 to print the values in increasing order.  or decreasing order.  or top of the tree first order.


// nov-27-2017-b
void rangePrint(bst_node_t *root, int val1, int val2) {
  if (root == NULL) return;

  // myself
  if (root->data >= val1 && root->data <= val2) // you could handle if val2 < val1
    printf("%d\n", root->data);

  // children
  rangePrint(root->left, val1, val2);
  rangePrint(root->right, val1, val2);
}
// in main
rangePrint(root, 10, 100);


// dec-06-2017-a
int allDifferent(bst_node_t *root) {
  if (root == NULL) return 1; // an empty node is different than its children

  // myself - am I different than my children
  if ((root->left != NULL && root->left->data == root->data) ||
      (root->right != NULL && root->right->data == root->data))
    return 0;
  
  // if made it past if, then looks ok at this node
  
  // left
  // right
  // put that all together
  if (allDifferent(root->left) && allDifferent(root->right))
    return 1;
  // note: that all works only if BST is correct, in sorted order.
}
// in main
if (! allDifferent(root)) {
  // something
}

// dec-06-2017-b - for you!