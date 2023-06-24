package encraption;

import java.util.Scanner;

public class Affine {
	public static Scanner read = new Scanner(System.in);
	static char element []= {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	static int q[]=new int[40];
	static  int l=0;
    static String crytotext="";
	
	public static void main(String[] args) {

	}

	
  

///////////////////////////////////////////////////

public static void reverse_encrypt(String text){
	 	 
	for (int i = text.length()-1; i >=0 ; i--)
	{
		System.out.print(text.charAt(i)+" ");
	}
	System.out.println();
}


////////////////////////////////

 

public static void Affine_encrypt(String text , int k0 , int k1)
{
	char x=' ';
	int pointer=0;
	
 
	if (cheakKey_UseGCD(k1, 26) != 0)
	{
		
		for (int i = 0; i < text.length(); i++) 
		{
			
		     x=text.charAt(i);
		     
		     if(thePoenter(x) != 0)
		     {
		    	 pointer = thePoenter(x);
		    	 
		    	 int r= ((pointer * k1 )+k0)%26;
		    	 
		    	 if(r<=0)
		    	 {
		    		 r=26+r;
		    	 }
		    	 x = element[r]; 
		    	 
		    	 crytotext +=x+"";
		     }
		   
		    
		}
		
		
		System.out.print(crytotext);
		
		
	}
	else
	{
		System.out.println(k1+" is not valid");
	}

}


public static void Affine_deencrypt(String cyper , int k0 , int k1)
{
	char x=' ';
	int pointer=0;
	crytotext="";
	
	int KeyInv=KeyInverse(q , 0 , 1 );
	
	if (KeyInv != 0)
	{
		for (int i = 0; i < cyper.length(); i++) 
		{
			 x=cyper.charAt(i);
		     
		     if(thePoenter(x) != 0)
		     {
		    	 pointer = thePoenter(x);
		    	 
		    	 int r= (KeyInv*(pointer - k0 ))%26;
		    	 
		    	 if(r<=0)
		    	 {
		    		 r=26+r;
		    	 }
		    	 x = element[r]; 
		    	 
		    	 crytotext +=x+"";
		     }
		}
		
		System.out.print(crytotext);
		
	}
	else
	{
		System.out.println(KeyInv+" is not found for key "+k1);
	}


}


public static int thePoenter(char x)
{
	for (int i = 0; i < element.length; i++) {
		
		if(x == element[i])
		{
			return i ;
		}
	}
	return 0;

}
////////////////////////////////////////////
 
 public static int cheakKey_UseGCD(int key, int n)
{
   	int R=0;           
    int N=n;
	int K=key;
	
	/*
	  Q     N      key      R
	  
	  8     26      3       2
	  1     3       2       1
	  2     2       1       0
	  
	  -     1       0       -
	   
	 * */
	
while(K != 0 && N != 1)
	{
	    q[l]=N/K;
    	R=N%K;
        N=K;
        K=R;
        l++;
	}
	
	if(K== 0 && N == 1)
	{
    	return key;
    }
	else
	{
      return 0;
	}
	 
}


public static int KeyInverse(int q[], int t1 , int t2 )
{ 
     int i=0;
     int T=0;
     int T1=t1;
     int T2=t2;
     
     
     /*
      
       T=T1-(T2*Qi)
       
       Q   T1   T2   T
       
       8   0    1    -8
       
       1   1   -8     9
       
       2   -8   9    -26
       
       -    9   -26   -
        
      * */
		while( i <l)
    	{
		 T=T1-(T2*q[i]);
         T1=T2;
         T2=T;
         i++;
    	}
	
	 if(i == l)
		{
			if(T1 >0)
			{ 
				return T1;
			}
			else
			{
		  
			   return 26+T1;
			}
		}
		
		else
		{
			return 0;

		}


}





 




}