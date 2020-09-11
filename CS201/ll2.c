
//C++    g++
#include<stdio.h>
#include<stdlib.h>

struct box {
  int id;
  struct box *next;
};

box *head = 0;
box *tail = 0;

//use this with an ordered linked list
//returns the box previous to where val belongs
box *search(int val) {
  box *prev = 0;
  box *curr = head;
  //loop stops if we run out of boxes or val<=curr->id
  while (curr!=0 && val>curr->id) {
    prev = curr;
    curr = curr->next; //incrementation
  }
  return prev;
}

void insert(int);  //declares function insert
void append(int);  //declares function append

//put the val into the list so that the list is
//sorted from smallest to largest
void orderedInsert(int val) {
  box *prev = search(val);
  box *nb = (box *)malloc(sizeof(box));
  nb->id = val;
  if (prev==0) {//beginning of list
    insert(val);
  }
  else if (prev==tail) {//end of list
    append(val);
  }
  else {//middle
    nb->next = prev->next;
    prev->next = nb;
  }
}

void insert(int val) {
  if (head) {
     box *nb = (box *)malloc(sizeof(box));
     nb->id=val;
     nb->next = head;
     head = nb;

  }
  else {
     head = tail = (box *)malloc(sizeof(box));
     head->id = val;
     head->next = 0;
  }
}

void append(int val) {
  if (tail) {
     box *nb = (box *)malloc(sizeof(box));
     nb->id=val;
     nb->next = 0;
     tail->next = nb;
     tail = nb; 
  }
  else {//tail==0, head=0
        //empty list
     head = tail = (box *)malloc(sizeof(box));
     head->id = val;
     head->next = 0;

  }
}

void prtList() {
 box* h = head;
 while (h) {
   printf("value=%d\n", h->id);
   h = h->next;
 }
}

void del(int val) {  //can assume the list is sorted
   //search list for a box where id==val
   //  box *prev = search(val);
   //  if prev==0: special case
   //  otherwise if prev==tail: special case "so there is nothing to delete"
   //  otherwise   val>= prev->next->id
   //               two cases
    //                val>prev->next->id
   //                 val==prev->next->id: delete the box free(void *ptr)
   //  -no such box don't do anything
   //  -find a box in the middle with curr->id==val
   ////       prev->next = curr->next
   box *temp = (box*) malloc(sizeof(box));
   box *prev = search(val);
   box *curr = prev->next;

   if(curr->next==0) // end of list
   return;
   if(curr==head){ //beginning of list
   temp=curr;
   free(temp);
   }
   else {       // middle of list
   temp = curr;
   prev = curr->next;
   free(temp);
   }

}


int main() {
  //get each command
  char command;
  int val;
  int nl;
  while ( scanf("%c", &command)) {
    printf(">>%c<<\n", command);
    switch(command) {
      case 'a':
        scanf("%d", &val);
        printf("number %d\n", val);
        append(val);
        break;
      case 'd':
        scanf("%d", &val);
        del(val);
        break;
      case 'i':
        scanf("%d", &val);
        printf("number %d\n", val);
        insert(val);
        break;
      case 'o':
        scanf("%d", &val);
        orderedInsert(val);
        break;
      case 'p':
        prtList();
        break;
      case 'q':
        return 0;
    }
    scanf("%c", &nl); //burns newline
  } 
}
