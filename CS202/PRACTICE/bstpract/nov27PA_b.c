#include
//nov 27 B  root as parameter AND  2 int , and prints all the data for that fits inbetween the two 
//parameters

int data
ptrleft and ptr right

void rangePrint(bst_node_t *root, int value1, int value2){
  //cannot deference a null pointer)
  if(root == NULL) return;

  
  //some if test right here
  //test to see if value is smaller
  
  //called some order
  if(value1 <= root->data && value2 >= root->data || value1 >= root->data && value2 <= root-data) 
    printf("\t%i\n",root->data);
  
  //answer from the children
  //still traversing through the tree anyways
  rangePrint(root->left, value); //left 
  rangePrint(root->right, value); //right

//to print this in order do in increasing 

/*
  small(root->left,value); //go to the furthest left in the tree
  
    if(root->data < value)
      printf("\t%i\n",root->data); //print myself
      
  small(root->right,value); //go to the right nod then


*/


}


//int main(){
small(root,40);
