#include<iostream>
#include<cstring>
#include<string>
#include<stdlib.h>

using namespace std;

struct trie{
  int end;  //states whether this is the end of the wor
  trie *children[25]; //for a-z could quickly traverse by taking -97 lower letter to get child node
  char letter;
};

int highestLevel=0;

trie *initTrieNode(){
  //trie *ptr = (trie *)malloc(sizeof(trie *));
  trie *ptr = new trie;
  ptr->end = 0;
  for(int i = 0;i < 25; i++){
    ptr->children[i] = NULL;
  }
}

void LetterInsert(trie *&next,char let){
  next = initTrieNode();
  next->letter = let;
}

trie *letterSearch(trie *ptr,char x[]){
  trie *searchnode = ptr;
  int i = 0;
  while(i<strlen(x)||searchnode==NULL){ //the word does not end or we hit a null ptr). )
    searchnode = searchnode->children[x[i]-97];
  }
  return searchnode;
}




/*
trie *lookup(trie *root, char word[] ){
  trie *ptr;
  char c = word[0];  
  root->children[c-65] = ((trie*) malloc(sizeof(trie)));
  ptr=root->children[c-65];  
  for(int i=0;i<strlen(word);i++){
      if(strlen(word)>highestLevel&&i>highestLevel){
        highestLevel++;
        ptr->children[c-65]= ((trie*) malloc(sizeof(trie)));
      }
      if(ptr==NULL||ptr->end!=1){
        ptr->end=0;
      }
      c=word[i-1];
      ptr=ptr->children[c-65];
      cout<<c<<endl;
  }
  return ptr;
}
*/

void insert(trie *root, char word[]){
  trie *ptr;
//ptr=lookup(root, word);
  if(ptr==NULL||ptr->end!=1){\
    ptr->end=1;
  }
}


int main(){

  trie *root = initTrieNode();

  char testna[] = "tree";
  int i = 0;
  while(i<strlen(testna))
    cout << testna[i++]-97 << endl;


  char test[]= "TREE";
  char test2[]= "TRE";
//  trie *root = new trie;
  //insert(root, test);
  //lookup(root, test);
  //lookup(root, test2);

//each word as an array of nodes

  return 0;

}
