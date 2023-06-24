package encraption;

import java.util.Scanner;

public class HillCipher {

	static  Scanner read = new Scanner(System.in);
	public static char [] element= {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};;

    static String M="HelloHuSSein".toLowerCase();
    static String C="";
    
	public static void main(String[] args) {
	    
	
	    int K[][]= { {11,22}
	    	        ,{14,18} 
	    	       };
	    
	    int Mseg[]=new int[K.length];
	    
	    
	    if(K.length == K[0].length)
	    {
	    	int k=0;
		      for (int i = 0; i < M.length(); i++)
		      {
				
			    	for (int j = i; j < i+2; j++)
			    	{
						
			    		if(M.charAt(j) != ' ')
			    		{
			    			if(getIndex(M.charAt(j)) != -1)
			    			{
			    				Mseg[k]= getIndex(M.charAt(j));
			    				k++;
			    			}
			    			
			    		}
			    		
			    		else
			    		{
			    			Mseg[j]=26;
			    		}
			    		
					}
			    	
			     C +=encraption(Mseg , K);
		    	i++;
		    	k=0;
			}
		      
		      System.out.println("THE Message : "+M);

		      System.out.println("THE Cyper Message : "+C);
	    }
	    
	    
	    System.out.println("\nThe Array of K != seqer " );
	}

	
	private static String encraption(int[] mseg, int[][] k) {
		int x =0;
		String s="";
		for (int i = 0; i < k.length; i++) 
		{
			for (int j = 0; j < k.length; j++) 
			{
				  x +=  mseg[j]*k[j][i]   ;
			}
			s +=element[x%26];
			x=0;
		}
		
		return s;
	}

	 
	private static int getIndex(char c) {
		for (int i = 0; i < element.length; i++)
		{
			if(c == element[i] )
			{
				return i;
			}
		}
		return -1;
	}
	
	
	 
}
