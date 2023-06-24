package encraption;

 import java.util.Scanner;

public class Caesar_algorithm {
	public static Scanner read = new Scanner(System.in);
	static char element []= {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	static int q[]=new int[40];
	static  int l=0;
    static String crytotext="";
    
    
	public static void main(String[] args) {
 
	 
		String text ="Hello Hussein";
		 
		int key = 182;
		char cyperText[]=Encraption(key, text);
		char plaintText [] = Descraption(key, cyperText);
		print(cyperText);
		 
 		print(plaintText);
 	
	}

	//depended on ASCE code
	static char[]  Encraption(int key,String text)
	{
		char cyperText []= new char[text.length()]; 
         
		char c;
		 
 		for (int i = 0; i < cyperText.length; i++) 
		{ 
		    c=text.charAt(i);
		    int x1=0;
			
			if(c >='A' && c<='Z')
			{
				
				if((c+key) <=90)
				{
					c=(char)(c+key);
				}
				else
				{
				    x1=(c+key)%90;
					c=(char)(64+x1);
				}
				 cyperText[i]=c;
 			}
			
			else if(c >='a' && c<='z')
			{
				if((c+key) <=122)
				{
					c=(char)(c+key);
				}
				else
				{
				    x1=(c+key)%122;
					c=(char)(96+x1);
				}
				 cyperText[i]=c;
				
			}
 			 
		}
		return cyperText;
 
	 }
 
    static char[] Descraption(int key,char [] cyperText)
	{
		char plantText []= new char[cyperText.length];
 		
		for (int i = 0; i < cyperText.length; i++) 
		{ 
			int x2=0;
			
			if(cyperText[i] >='A' && cyperText[i] <='Z')
			{
				
					if((cyperText[i]-key) >= 65) 
					{
			
						plantText[i]=(char)(cyperText[i]-key);
				    }
				
				 else
				    {  
					    x2=64%(cyperText[i]-key);
				 
						plantText[i]=(char)(90-x2);
				    }
			}
			
			
		 else if(cyperText[i] >='a' && cyperText[i]<='z')
			{
				 if( (cyperText[i]-key)  >= 97 )
					 {
						plantText[i]=(char)(cyperText[i]-key);
					 }
			    else
				    {
				     x2=96%(cyperText[i]-key);
					 plantText[i]=(char)(122-x2);
				    }
					
		     }
 		
		}
		
		
		return plantText;
		
	}
	 
	static void print(char [] text)
	{
		for (int i = 0; i < text.length; i++) {
			System.out.print(text[i]+" ");
		}
	}
  
	
	////////////////////////////////
	
	////////Depended on array of elements

	public static void caser_encrypt(String text , int key)
	{
		
		char x;
		int pointer;
		for (int i = 0; i < text.length(); i++) 
		{		
		     x=text.charAt(i);
		     
		     if(thePoenter(x) != 0)
		     {
		    	 pointer = thePoenter(x);
		    	 
		    	 int r= (pointer + key ) % 26;
		    	 
		    	 if(r<=0)
		    	 {
		    		 r = 26+r;
		    	 }
		    	 x = element[r]; 
		    	 
		    	 crytotext +=x+"";
		     }	    
		}
			
		System.out.print(crytotext);
		
	}


	public static void caser_deencrypt(String cyper , int key)
	{
		char x;
		int pointer;
		crytotext="";
		for (int i = 0; i < cyper.length(); i++) 
		{
			
		     x=cyper.charAt(i);
		     
		     if(thePoenter(x) != 0)
		     {
		    	 pointer = thePoenter(x);
		    	 
		    	 int r= (pointer - key )%26;
		    	 if(r<=0)
		    	 {
		    		 r= 26+r;
		    	 }
		    	 x = element[r]; 
		    	 
		    	 crytotext +=x+"";
		     }
		}
		System.out.print(crytotext);
		
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

	///////////////////////////////////////////////////

}
