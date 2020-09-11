#include<stdio.h>
#include<stdlib.h>

struct box {
  int id;
  struct box *next;
};

struct box *head = 0;
struct box *tail = 0;

//use this with an ordered linked list
//returns the box previous to where val belongs
struct box *search(int val) {
  struct box *prev = 0;
  struct box *curr = head;
  //loop stops if we run out of boxes or val<=curr->id
  while (curr!=0 && val>curr->id) {
    prev = curr;
    curr = curr->next;
  }
  return prev;
}

void insert(int);  //declares function insert
void append(int);  //declares function append

//put the val into the list so that the list is
//sorted from smallest to largest
void orderedInsert(int val) {
  struct box *prev = search(val);
  struct box *nb = malloc(sizeof(struct box));
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
     struct box *nb = malloc(sizeof(struct box));
     nb->id=val;
     nb->next = head;
     head = nb;

  }
  else {
     head = tail = malloc(sizeof(struct box));
     head->id = val;
     head->next = 0;
  }
}

void append(int val) {
  if (tail) {
     struct box *nb = malloc(sizeof(struct box));
     nb->id=val;
     nb->next = 0;
     tail->next = nb;
     tail = nb; 
  }
  else {//tail==0, head=0
        //empty list
     head = tail = malloc(sizeof(struct box));
     head->id = val;
     head->next = 0;

  }
}

void prtList() {
 struct box* h = head;
 while (h) {
   printf("value=%d\n", h->id);
   h = h->next;
 }
}

void del(int val) {  //can assume the list is sorted
   //search list for a box where id==val
   //  struct box *prev = search(val);
   //  if prev==0: special case
   //  otherwise if prev==tail: special case "so there is nothing to delete"
   //  otherwise   val>= prev->next->id
   //               two cases
    //                val>prev->next->id
   //                 val==prev->next->id: delete the box  ---- free(void *ptr)
   //  -no such box don't do anything
   //  -find a box in the middle with curr->id==val
   ////       prev->next = curr->next
   //
  struct box *prev = search(val);
  if(val==head->id){
  prev->next = head-> next;
  free(head);
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
