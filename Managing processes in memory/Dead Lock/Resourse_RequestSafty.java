package lab;

public class Resourse_RequestSafty {

 	 
	static int resourse[]= {10,5,7};
	static int n_p = 5;
	static int n_r=3;
	static  int [] avialable = new int [n_r];
	static int [][] need = new int[n_p][n_r];
    static int [] work = new int[n_r];
	static int [] comp=new int [n_p];
	static int c=1;
	static int k=0;
	
	static int [][] allocation = {{0,1,0},
             {2,0,0},
             {3,0,2},
             {2,1,1},
             {0,0,2} };	

	static int [][] max =  { {7,5,3},
             {3,2,2}, 
             {9,0,2},
             {2,2,2},
             {4,3,3} };
	public static void main(String[] args) {

		
		     
		  printInput(allocation , max);
		  Clculateavialable(allocation);
		  //work=avialable; 
		  ClculateNeed(max,allocation);
		 
		  
		  process();
		  System.out.println("complete process");
		  System.out.println();
		  
		  for (int j = 0; j < n_p; j++) 
		  {
			  System.out.println("p"+j+" "+comp[j]);
		  }
      
		  
		  
		  int [] req= {1,0,2};
		  int p=1;
		  System.out.println("----------------------------\nRequest Resourse for P"+p);

		  cheakRequest(req,p);
		 
		  System.out.println();
		  System.out.println();
		  System.out.println(c);
		  System.out.println(k);

		 
	}
	
	static void process()
	{
		c=1;k=0;comp=new int [n_p];
		 while(c<=n_p && k<=n_p)
		  {      
			  for (int i=0; i < n_p; i++) 
			  {
				  boolean x=false;
				  
				  if(comp[i] == 0)
				  {
					  for (int j = 0; j < n_r; j++)
					  {
						  if(need[i][j] <= work [j] )
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
					  System.out.print("P"+i+"->");
					  
					  comp[i] = c;
					  c++;
				  }
			  }
			  k++;
			  
			 
			  for (int i = 0; i < comp.length; i++)
			  {
				if(comp[i]==0)
				{
					  System.out.println("\nP"+i+"");
					  k=n_p+1;
					  return;
				}
			  }
		  }
		 System.out.println();
	}
	


 	private static void cheakRequest(int[] req,int p) 
 	{
 		int x=-1;
 		
 		for (int i = 0; i < req.length; i++)
 		{
			if(req[i] <= need[p][i] && req[i] <= avialable[i])
			{
				x=1;
			}
			else { x = -1;break;}
		}
 		
 		if(x==1)
 		{
 			
	 			for (int i = 0; i < req.length; i++) 
	 			{
					need[p][i]=need[p][i]-req[i];
					allocation[p][i]=allocation[p][i]+req[i];
					avialable[i] = avialable[i]-req[i];	
				}
	 		
	 		  print(avialable , need , allocation);
	 		  
			  process();
			  
			  if(k>n_p)
			  {
				  System.out.println("the System stata is unSafty , So all the change value is return ");
			  
				  for (int i = 0; i < req.length; i++) 
		 			{
						need[p][i]=need[p][i]+req[i];
						allocation[p][i]=allocation[p][i]-req[i];
						avialable[i] = avialable[i]+req[i];	
					}
				  
				  print(avialable , need , allocation);
				   
			  }
			  
			  
			  else
			  {
				  System.out.println("complete process ,The System state is Safty");
				  System.out.println();
				  
				  for (int j = 0; j < n_p; j++) 
				  {
					  System.out.println("p"+j+" "+comp[j]);
				  }
			  }
		 
		  
 		}
 		else
 		{
 			  System.out.println("The request is up of need or avialable");
 		}
 		
	}



	private static void print(int[] avialable2, int[][] need2, int[][] allocation2) {
		 System.out.println("\t\nNew Allocation \n");
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
		  System.out.println("\nNew Need :-\n\nA B C ");

		  for (int i = 0; i < n_p; i++) 
		  {
			  for (int j = 0; j <n_r; j++) { 
			   System.out.print(need[i][j]+" ");
			  }
			  System.out.println();
		  }
		  System.out.println();	

		  System.out.println("\nNew Avialable:-\nA B C");
		  
		  for (int i = 0; i < n_r; i++) 
		  { 
			    work[i]=avialable2[i];
			   System.out.print(work[i]+" ");	  
		  }
		  System.out.println();
		  System.out.println();	
		
	}

	private static void ClculateNeed(int[][] max, int[][] allocation) {
		  for (int i = 0; i <n_p; i++) {
				
			  for (int j = 0; j <n_r; j++) {
				
				  need[i][j]=max[i][j]-allocation[i][j];
			}
		}
		  System.out.println("\nNeed :-\n\nA B C ");

		  for (int i = 0; i < n_p; i++) 
		  {
			  for (int j = 0; j <n_r; j++) { 
			   System.out.print(need[i][j]+" ");
			  }
			  System.out.println();
		  }
		  System.out.println();		
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
			   work[i]=avialable[i];
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
	      System.out.println("\tMax\n");
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
