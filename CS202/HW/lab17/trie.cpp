#include<iostream>
#include<cstring>
#include<string>
#include<fstream>


using namespace std;



struct *trie{
  //char word[];  //could also be used as an int for level by getting the length of the stored word
  trie *children[25]; //for a-z could quickly travere by taking letter-65 to get child node
  int end; 
};

trie* newnode(){
  
  trie *temp = (trie*) malloc(sizeof(trie));
  
  for(int i=0;i<25;i++){
    temp->children[i]=NULL;
  }
  int end = 0;
  
  return temp;  
}




trie *lookup(trie *root, char word[] ){
  trie *ptr;
  char c = word[0];
  ptr=root->children[c-65];
  for(int i=0;i<=strlen(word);i++){
    if(ptr==NULL||ptr->end!=1)
	ptr->end=0;
    c=word[i];
    ptr=ptr->children[c-65];
    } 
  return ptr;
}




void insert(trie *root, char word[]){
  trie *ptr;
  ptr = newnode();
  //ptr = (trie*)malloc(trie);
  
  ptr=lookup(root, word);
  if(ptr==NULL||ptr->end!=1)
    ptr->end=1;
  
}




int main(){
  
  
  char test[] = "TREE";
  
  insert(root,test);
  lookup(root,test);
  
  /*

  trie mytree = (trie*)malloc(trie);
  mytree->word = NULL;
  
  for(int i = 0; i < 25; i++){
    mytree->children[i]=NULL;
  }  
  
  string str;
  while (cin >> str){
    insert(mytree,str);
  }
  */
    
    
  

  return 0;

}
