
#include "types.h"
#include "user.h"
#include "stat.h"
#include "param.h"
#include "mmu.h"
#include "proc.h"


int
main(int argc, char *argv[])
{
  if(argc < 1){
    printf(2, "Usage: ./free [-h]\n");
    exit();
  }

  	
  struct system_info z;
	system_load(&z);
  


  int x = 0;
  int psizein; 
  char psize[] = {'G','M','K','B'};
	
  printf(1,"number of in-use processes: %d\n",z.num_procs);
  //if -h argument is present we are converting things into human terms
  if(!strcmp(argv[1],"-h")){
     if(z.uvm_used > 2000000000){
        x = z.uvm_used / 1000000000;
	psizein = 0;
     }
     else if(z.uvm_used > 2000000){
	x = z.uvm_used / 1000000;
	psizein = 1;
     }
     else if(z.uvm_used > 2000){
	x = z.uvm_used / 1000;
	psizein = 2;
     }
     else{
	psizein = 3;
     }
     printf(1,"total size of all in-use processes: %d%cB\n",x,psize[psizein]);
  }
  else //default if no -h argument  
  	printf(1,"total size of all in-use processes: %d\n",z.uvm_used);

  printf(1,"number of cpus in use: %d\n", z.num_cpus);
  exit();

}
