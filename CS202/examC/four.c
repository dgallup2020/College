#include<stdio.h>
#include<stdlib.h>

typedef struct BST_NODE_T {
  char *data;
  struct BST_NODE_T *left, *right;
} bst_node_t;

int allOrNothing(bst_node_t *root){
 if(root == NULL) return 1;

 int leftvalue = allOrNothing(root->left);
    if( ( (root->left==NULL)&&(root->right!=NULL) ) || ( (root->left!=NULL)&&(root->right==NULL)  ) )
	return 0;
 int rightvalue = allOrNothing(root->right);
 
 return rightvalue && leftvalue;
 
}


int main(int argc, char*argv[]){
 int whatever = allOrNothing(root); 
 return 0; 
}