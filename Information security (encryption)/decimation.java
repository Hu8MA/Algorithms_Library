package encraption;

import java.util.Scanner;

public class decimation {
	
	public static Scanner read = new Scanner(System.in);
	static char element []= {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	static int q[]=new int[40];
	static  int l=0;
	public static void main(String[] args) {
		     
		      int key=0;int Ikey=0;
		      key =cheak_valided_Key(15, 26);
			  Ikey=KeyInverse(q, 0, 1,key);
 	  
	}
	
	public static char [] encraption(String text , int key  ) {
		
		char cyperText []= new char[text.length()]; 
        
		System.out.print("\nEncraption : ");
		for (int i = 0; i < text.length(); i++) 
		{  
			for (int j = 1; j < element.length; j++) {
				
				if(text.charAt(i) == element[j])
				{
				  if((j*key)%26 == 0)
						{
						   cyperText[i]=element[26];

						}
					else
					{
						   cyperText[i]=element[(j*key)%26];

					}
				}
			}
		 System.out.print(cyperText[i]+" ");
		}
		
		 return cyperText;
 	}
	
	    
    public static void Disencraption(char cyperText [] ,int Ikey )
    {
    	System.out.print("\n\nDisencraption : ");
		char plantText[]=new char [cyperText.length];
    	
 	   for (int i = 0; i < plantText.length; i++)
 	   {
	
 		   for (int j = 1; j < element.length; j++) {
				
				if(cyperText[i] == element[j])
				{
				  if((j*Ikey)%26 == 0)
						{
					       plantText[i]=element[26];
						}
					else
					{
						plantText[i]=element[(j*Ikey)%26];
					}
				}
			}
 	  
 		System.out.print( plantText[i]+" ");
 	   
 	   }
    }
    
    
	
	public static int cheak_valided_Key(int key, int n)
	    {
	    	   	int r=0;
	            int n1=n;
	        	int key1=key;
	        while(key1 != 0 && n1 != 1)
	        	{
	    		    q[l]=n1/key1;
	            	r=n1%key1;
	                n1=key1;
	                key1=r;
	                l++;
	        	}
	        	
	        	if(key1 == 0 && n1 == 1)
	        	{
	        		System.out.println(key+" is valid");
		        	return key;
		        	}
	        	else
	        	{
	        	 System.out.println(key+" is not valid");
                  return 0;
	        	}
	        	 
	    	}
	    
	    
    public static int KeyInverse(int q[], int t1 , int t2 , int key)
	    { 
	         int k=0;
             int T=0;
             int T1=t1;
             int T2=t2;
	    		while( k < l)
	        	{
	    		 T=T1-(T2*q[k]);
	             T1=T2;
	             T2=T;
	             k++;
	        	}
	    	
	    	 if(k == l)
	    		{
	    			if(T1 >0)
	    			{
	    				System.out.println("Inverse "+key+" is --> "+T1 );
	    				return T1;
	    			}
	    			else
	    			{
	    			   System.out.println(T1);
	    			   System.out.println("Inverse  "+key+" is --> "+(26+T1));
	    			   return T1;
	    			}
	    		}
	    		
	    		else
	    		{
 				return 0;

	    		}
	     }


    
 




}
