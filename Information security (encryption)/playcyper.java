package encraption;

import java.util.Random;

public class playcyper {


	static char ar [][]=new char[5][5];
	public static void main(String[] args) {

		 String text = "Hussein is good programmer";
 
		System.out.println(text);
		text=remove_space(text);
 
		text = segment(text);
		System.out.println("\n\ntext to encraption : \n"+text);

		String g=genratedString();
		ar= genraterArray(g);
		
		
		
		//////////////////////////
		
		System.out.println("\nUniq Array Chiper used to encrypt text");
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				System.out.print(ar[i][j]+" ");
			}
			System.out.println(" ");
		}
		
	}

	private static String genratedString() {
		
		Random r = new Random();
		String x="";
		for (int i = 0; i <120; i++) {
			
			   char s =(char) r.nextInt(97 , 123);
				
			  
			   if(uniq(x , s) == 0 )
			   {
				  if(s !='j')
				   {
					   x +=""+s;
				   }
				    
			   }
				
			if(x.length() == 25)
			{
				break;
			}
			
		}
	 
		return x;
	}

	private static int uniq(String x, char s) {
		
 
		for (int i = 0; i < x.length(); i++) 
		{
			if(s == x.charAt(i))
			{
				return -1;
			}
		}
		
		return 0;
	}

	private static char[][] genraterArray(String g) {
		int k=0;
		char x[][]=new char[5][5];
		for (int i = 0; i < x.length; i++) 
		{
			for (int j = 0; j < x.length; j++) 
			{
				x[i][j] = g.charAt(k);
				k++;
			}
		}
		
		return x;
	}

	private static String segment(String text) {
	String x="";
	
		for (int i = 0; i < text.length()-1; i= i+2) 
		{
			if( text.charAt(i) != text.charAt(i+1))
			{
				 x +=""+text.charAt(i) + text.charAt(i+1)+" ";
			}
			else
			{
				 x +=""+text.charAt(i)+"X ";
				 i--;
				 
				 if(text.length()%2 == 0)
				 {
					 text +="X ";
				 }
				 
				 
			}
				 
		}
		
		
		return x;
	}

	private static String remove_space(String text) {
		String x ="";
		for (int i = 0; i < text.length(); i++) {
			if(text.charAt(i) != ' ')
			{
				x +=text.charAt(i);
			}
		}
		
		
		return x;
	}


}
