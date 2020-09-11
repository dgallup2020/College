#include


int total(bst_node_t *root){
  if(root == NULL) return 0;
  
  int count = 0;
  //some if test right here
  
  //answer from the children
  int countLeft = total(root->left);
  int countRight = total(root->right);
  
  //return casse
  return count + somehting else


}
