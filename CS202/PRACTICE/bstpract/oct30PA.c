#include
//OCT 30 root as parameter, and returns the number of nodes that have a non-null word 

int total(bst_node_t *root){
  //cannot deference a null pointer)
  if(root == NULL) return 0;
  
  int count = 0;
  //some if test right here
  //CHECK THIS NODE WE ARE CURRENTLY IN TO SEE WHETHER IT HAS A NON-NULL WORD
  if(root->word!=NULL)
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
