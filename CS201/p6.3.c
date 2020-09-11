#include<stdio.h>
#include<string.h>

//not a variable; its a new type; a programmer defined type
struct student {  //parts are called members or fields
  int ssn;
  char lname[20];
  char fname[20];
  int standing;
};

struct student studts[100]; 

//searches from index 0 to index sz for the largest standing
//returns the index of the student with the largest standing
int posLargest(int sz) {
  int largestIndex = 0;
  int i;
  for(i=1; i<=sz; i++)
     if (studts[i].standing>studts[largestIndex].standing)
        largestIndex = i;
  return largestIndex;
}

int main() {
  /*
  struct student s;
  struct student s2;
  s.ssn = 991234567;
  s2.ssn = 991678543;
  strcpy (s.lname, "Smith");
  strcpy (s.fname, "Alice");
  s.standing = 100;
  printf("ssn=%d last name = %s standing=%d\n",s.ssn, s.lname, s.standing);
  */
   
  int i = 0;
  while( 1==scanf("%d", &studts[i].ssn) ) {
    scanf("%s", studts[i].lname);
    scanf("%s", studts[i].fname);
    scanf("%d", &studts[i].standing);
    i++;
  }
  //working?
  int j;
  for(j=0; j<i; j++)
    printf("%s\n", studts[j].fname);

  //Sort the array so the students are arranged from lowest standing to highest
  
}


