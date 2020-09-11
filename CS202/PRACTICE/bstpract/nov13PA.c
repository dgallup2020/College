#include
//NOV 13 4. count the number of nodes with only one node. 

int total(bst_node_t *root){
  //cannot deference a null pointer)
  if(root == NULL) return 0;
  
  int count = 0;
  //some if test right here
  //check to see if either node has only node.
  if(root->left == NULL && root->right != NULL || root->left != NULL  && root->right == NULL)
    count++;
  
  //answer from the children
  //still traversing through the tree anyways
  int countLeft = total(root->left);
  int countRight = total(root->right);
  
  //return case
  return count + countLeft + countRight;


}


//int main(){
int a = total(root);
