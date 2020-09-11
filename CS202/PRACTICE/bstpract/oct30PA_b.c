#include
//OCT 30 B  root as parameter, and returns the COMBINED LENGTH OF ALL WORDS IN THE TREE 

int total(bst_node_t *root){
  //cannot deference a null pointer)
  if(root == NULL) return 0;
  
  int count = 0;
  //some if test right here
  //CHECK THIS NODE THEN ADD TO THE TOTAL NUMBER OF WORDS
  //YOU NEED TO TEST IF A PTR IS NULL BEFORE USING IT
  if(root->word!=NULL) //NEED THIS OTHERWISE THERE WILL BE A SEG FAULT
    count += strlen(root->word);
  
  //answer from the children
  //still traversing through the tree anyways
  int countLeft = total(root->left);
  int countRight = total(root->right);
  
  //return case
  return count + countLeft + countRight;


}


//int main(){
int a = total(root);
