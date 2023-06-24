package lab;

public class DeadLock_Detection {


	 
	static int resourse[]= {7,2,6};
	static int n_p = 5;
	static int n_r=3;
	static int [] avialable = new int [n_r];
	static int [][] need = new int[n_p][n_r];
    static int [] work = new int[n_r];
	static int [] comp=new int [n_p];
	static int c=1;
	static int k=0;
	
	public static void main(String[] args) {

		 int [][] allocation = {{0,1,0},
				                {2,0,0},
				                {3,0,3},
				                {2,1,1},
				                {0,0,2} };	
		 
		      int [][] Request={{0,0,0},
				                {2,0,2}, 
				                {0,0,0},
				                {1,0,0},
				                {0,0,2} };
		     
		  printInput(allocation , Request);
		  Clculateavialable(allocation);
		  work=avialable; 
		  //ClculateNeed(Request,allocation);
		 
		  while(c<=n_p&& k<=n_p)
		  {
 
			  for (int i = 0; i < n_p; i++) 
			  {
				  boolean x=false;
				  
				  if(comp[i] == 0)
				  {
					  for (int j = 0; j < n_r; j++)
					  {
						  if(Request[i][j] <= work [j] )
						  {
							 x=true;
						  }
						  else {
							  x=false;
							  break;
							  }
					  }
				  }
				   if(x)
				  {
					  for (int j = 0; j < n_r; j++) 
					  {
						work[j] += allocation[i][j];
					  }
					  comp[i] = c;
					  c++;
				  }
			  }
			  
			  
			  int l=-1;
			  
			  for (int i = 0; i < comp.length; i++)
			  {
				if(comp[i]==0)
				{
					  l=1;
					  System.out.println("\nP"+i+" is non Saffty the System");
 				}
			  }
			  
			  if(l == -1)
			  {
				  System.out.println("All Process is Saffty");

			  }
			  
			  k++;
			  if(k==n_p)
			  {
				  return;
			  }
		  }
		   
		  System.out.println("complete process");
		  System.out.println();
		  
		  for (int j = 0; j < n_p; j++) 
		  {
			  System.out.println(comp[j]+"->"+"p"+j);
		  }
		  
		  for (int j = 0; j < resourse.length; j++) 
		  {
			  System.out.print(avialable[j]+" ");
		  }
		 
		  
	}
	

	private static void Clculateavialable(int[][] allocation) {
		 
		  for (int i = 0; i < n_p; i++) 
		  {
			   for (int j = 0; j < n_r; j++) 
			  {
				 avialable[j] +=allocation[i][j];
			  }
			 
		  }
		  
		  System.out.println("\nAvialable:-\nA B C");
		  
		  for (int i = 0; i < n_r; i++) 
		  {
			  avialable[i] = resourse[i]-avialable[i] ;
			   System.out.print(avialable[i]+" ");	  
		  }
		  System.out.println();
	
		
	}

	private static void printInput(int[][] allocation, int[][] max) {
 	
		 System.out.println("\tAllocation \n");
	      
	      System.out.println("P\t"+"A\t"+"B\t"+"C\t");
	      System.out.println();
	      for (int i = 0; i <n_p; i++) 
	      {
	    	  System.out.print("P"+i);
	    	  for (int j= 0;j < n_r; j++) 
		      {
	    	     System.out.print("\t"+allocation[i][j] );
	    	    
		      }
	    	  System.out.println();
	      }
	      System.out.println();
	      System.out.println("\tRequest\n");
	      System.out.println("P\t"+"A\t"+"B\t"+"C\t");
	      System.out.println();
	      for (int i = 0; i <n_p; i++) 
	      {
	    	  System.out.print("P"+i);
	    	  for (int j= 0;j < n_r; j++) 
		      {
	    	     System.out.print("\t"+max[i][j] );
	    	    
		      }
	    	  System.out.println();
	      }
	}



}
