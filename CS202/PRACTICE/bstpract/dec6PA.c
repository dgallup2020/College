#include
//DEC 6 B  root as parameter AND RETURNS 1 IF ALL THE NODES ARE DIFFERENT IN THE TREE ASSUMING THEY 
//ARE IN PROPER ORDER

int data
ptrleft and ptr right

int allDifferent(bst_node_t *root){
  //cannot deference a null pointer)
  if(root == NULL) return 1; //empty node is different
  //we immediately set it to 1 then we change it if anything changes

 
  
  //check to see if i am different from my children
  //some if test right here
  if(root->left!= NULL && root->data==root->left->data)
    return 0; //because then we don't need to check the right node
  if(root->right!= NULL && root->data==root->right->data)
    return 0;


//traversal through a test
  if(allDifferent(root->left)&& allDifferent(root->right))
  //answer from the children
  return 1;
  
  
  //righ


}


//int main(){
small(root,40);
