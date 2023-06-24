package defult;

import java.util.Scanner;

public class NapSake_Problem {

	static double capacity [];

	public static void main(String[] args) {
		Scanner read =new Scanner(System.in);
		System.out.println("enter the number of object ");
		int x=read.nextInt();
		int profits[]= new int [x];
		int weights[]= new int [x];
        
		System.out.println("\nenter the profits ");

         for (int i=0;i<profits.length;i++) {
        	 
        	 profits[i]=read.nextInt();
         }
 		System.out.println("\nenter the weight\n ");

		for (int i=0;i<weights.length;i++) {
			        	 
			weights[i]=read.nextInt();
           } 
		
		System.out.println("\nenter the capasety \n ");
           int c=read.nextInt();
          
		
		/// if the algorithm do on max Profits
           
           System.out.println();
       	System.out.print("array of P  : ");
		for (int i=0;i<profits.length;i++) {
			System.out.print(profits[i]+"  ");
		}
	      System.out.print("\narray of W  : ");
		for (int i=0;i<weights.length;i++) {
			System.out.print(weights[i]+"  ");
		}
	      System.out.println("\n");
           
		System.out.println("\nthe algorithm do on the max profits\n ");
		
		Sort_to_max(profits , weights , weights.length);
		
		/// print array P & W
		
		System.out.print("array of P  : ");
		for (int i=0;i<profits.length;i++) {
			System.out.print(profits[i]+"  ");
		}
	      System.out.print("\narray of W  : ");
		for (int i=0;i<weights.length;i++) {
			System.out.print(weights[i]+"  ");
		}
	      System.out.println("\n");

	       /// return the knapsack
		
		double maxprofit1 = knapsack(profits, weights,c, profits.length); 
		
		System.out.println("the profit = "+maxprofit1);
		
		
		// print array of capacity
	     
		System.out.print("\narray of capacity : ");
			for (int i=0;i<capacity.length;i++) {
				System.out.print(capacity[i]+"  ");
			}
		      System.out.println("\n\n------------------------------\n");
		      
		      
		
		      /// if the algorithm do on max weight
		      
		  
		   System.out.println("the algorithm do on the min weights \n");
		      
			  	Sort_tomin(weights,profits ,  weights.length);
			
		// print array of P & W
		  	
			System.out.print("array of P  : ");
			for (int i=0;i<profits.length;i++) {
				System.out.print(profits[i]+"  ");
			}
		      System.out.print("\narray of W  : ");
			for (int i=0;i<weights.length;i++) {
				System.out.print(weights[i]+"  ");
		      
			}
		      System.out.println("\n");
		      
		      
              /// return the knapsack
			
			double maxprofit2 = knapsack(profits,weights ,c, profits.length); 
			
			
			// print array capacity
			
			System.out.println("the capacity = "+maxprofit2);
			
		      System.out.print("\narray of cost : ");
				for (int i=0;i<capacity.length;i++) {
				System.out.print(capacity[i]+"  ");
			}
		      System.out.println("\n");	
		      
		      System.out.println("\n\n------------------------------\n");

		      
		      /// if the algorithm do on max weight
		      
			  
			   System.out.println("the algorithm do on the min profit \n");
			      
				  	Sort_tomin(  profits, weights , weights.length);
				
			// print array of P & W
			  	
				System.out.print("array of P  : ");
				for (int i=0;i<profits.length;i++) {
					System.out.print(profits[i]+"  ");
				}
			      System.out.print("\narray of W  : ");
				for (int i=0;i<weights.length;i++) {
					System.out.print(weights[i]+"  ");
			      
				}
			      System.out.println("\n");
			      
			      
	              /// return the knapsack
				
				double maxprofit3 = knapsack(profits,weights ,c, profits.length); 
				
				
				// print array capacity
				
				System.out.println("the capacity = "+maxprofit3);
				
			      System.out.print("\narray of cost : ");
					for (int i=0;i<capacity.length;i++) {
					System.out.print(capacity[i]+"  ");
				}
			      System.out.println("\n");	
	}
	 
	
	public static double  knapsack(int p[] , int w[] ,int c , int n) {
		
		capacity=new double [n];
		int u=c;
		double maxprofit=0;
		int i;
		
 		for ( i=0 ; i< n ;i++) {
			
 			if( w[i] > u) {
				
 				capacity[i]=(double)u/w[i];
 				maxprofit +=maxprofit + (p[i]*capacity[i]);
 				i=n;
 				
 				/// use i=n  is other way  for " break "
 				}
 		
 		else {
 			capacity[i]=1;
				u =u- w[i];
				maxprofit +=p[i];
 			}
 			}
 		
		return maxprofit;	
	}
	
	
	
	
	
public static double  knapsack2(int p[] , int w[] ,int c , int n) {
		
	capacity=new double [n];
		int u=c;
		double maxprofit=0;
		int i;
		
 		for ( i=0 ; i< n ;i++) {
			
 			if( w[i] > u) {
				
 				
 			       break;
 			}
 		
 			else {
 				capacity[i]=1;
				u =u- w[i];
				maxprofit +=p[i];
 			}
 		}
		
 		if(i<n) {
 			capacity[i]=(double)u/w[i];
				
				maxprofit +=maxprofit + (p[i]*capacity[i]);
 		}
	
		
		return maxprofit;
		
		
	}
	 
	
	static void Sort_to_max(int array[],int array2[],int n) {
		
	
		
		for (int i=1;i<n;i++) {
			
			int key = array[i];
			int key2=array2[i];
			
			int j=i-1;
			
			while(j>=0 && array[j]<key) {
			
				array[j+1]=array[j];
				array2[j+1]=array2[j];
				
				j=j-1;
			}
			
			array[j+1]=key;
			array2[j+1]=key2;
		}
	}
	
	

	static void Sort_to_min(int array[],int array2[],int n) {
		
	
		
		for (int i=1;i<n;i++) {
			
			int key = array[i];
			int key2=array2[i];
			
			int j=i-1;
			
			while(j>=0 && array[j]>key) {
			
				array[j+1]=array[j];
				array2[j+1]=array2[j];
				
				j=j-1;
			}
			
			array[j+1]=key;
			array2[j+1]=key2;
		}
	}
}
