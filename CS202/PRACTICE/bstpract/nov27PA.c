#include
//nov 27  root as parameter AND int , and prints all the data for all nodes that are less than 2nd 
//parameter

int data
ptrleft and ptr right

void small(bst_node_t *root, int value){
  //cannot deference a null pointer)
  if(root == NULL) return;
  
  //some if test right here
  //test to see if value is smaller
  
  //called some order
  if(root->data < value) //myselft
    printf("\t%i\n",root->data);
  
  //answer from the children
  //still traversing through the tree anyways
  small(root->left, value); //left 
  small(root->right, value); //right

//to print this in order do in increasing 

  small(root->left,value); //go to the furthest left in the tree
  
    if(root->data < value)
      printf("\t%i\n",root->data); //print myself
      
  small(root->right,value); //go to the right nod then





}


//int main(){
small(root,40);
