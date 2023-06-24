package encraption;
 
public class GeometricPatterns {
 
	  public static void main(String[] args) {
		     
	    }
		
	
	public static char [][] ColumnEn(char [][] text , String key)
	{
		int x = 0 ;
		int k1; 
		
		char cyper[][]=new char[text.length][text[0].length];
		 
		while( x < key.length() )
		{
			k1=Integer.parseInt(String.valueOf(key.charAt(x)))-1;
		 
			System.out.println();
			for (int i = 0; i < text.length; i++) 
			{
		       cyper[i][x]=text[i][k1];
	        }
			
		    x++;
		
		}
		 
		//print
		System.out.println("\nEncraption");
	
		for (int i = 0; i < cyper.length; i++) {
			
			for (int j = 0; j < cyper[i].length; j++) {
				System.out.print(cyper[i][j]+ " ");
			}
			System.out.println();
		}
		
		
		return cyper;
		
	}
	
	 
	public static void ColumnDe(char [][] text , String key)
	{
		int x =0;int k1; 
		
		char cyper[][]=new char[text.length][text[0].length];
		 
		while(x<key.length())
		{
			k1=Integer.parseInt(String.valueOf(key.charAt(x)))-1;
		 
			System.out.println();
			for (int i = 0; i < text.length; i++) 
			{
		       cyper[i][k1]=text[i][x];
	        }
		    x++;
		
		}
		 
		
		//print
		System.out.println("\nDecrption");
	
		for (int i = 0; i < cyper.length; i++) {
			
			for (int j = 0; j < cyper[i].length; j++) {
				System.out.print(cyper[i][j]+ " ");
			}
			System.out.println();
		}
		
		
	 
		
	}
	 
	 
	public static char [][]  TextToArrayColumn(String text , String key)
	{
	   
		text=ConCast(text);
		
		System.out.println(text+" ==> "+text.length());	
	 
	
		int c = key.length();
		
		int r=text.length()/c;
		
		
		double r1=(double)text.length()/c;
		
		if(r<r1)
		{
			r++;
		}
		
		int p=0;
	
		char txt [][]=new char[r][c];
		
		for (int i = 0; i < txt.length; i++)
		{ 
			for (int j = 0; j < txt[i].length; j++) 
			{
				
				if(p<text.length() &&  text.charAt(p) != ' ')
				{
					txt [i][j]=text.charAt(p);
	
				}
				else
				{
					txt [i][j]='x';
	
				}
				p++;
				
			}
		}
		
		
		
		for (int i = 0; i < txt.length; i++) {
			for (int j = 0; j < txt[i].length; j++) {
				System.out.print(txt[i][j]+" ");
			}
			System.out.println();
		}
		
		return txt;
		
		
		
		
	}
	
	 
	/////////////////////////////////////////////
	 
	
	public static char [][] RowEn(char [][] text , String key)
	{
		int x =0;int k1; 
		
		char cyper[][]=new char[text.length][text[0].length];
		 
		while(x<key.length())
		{
			k1=Integer.parseInt(String.valueOf(key.charAt(x)))-1;
		 
			System.out.println();
		    cyper[x]=text[k1];
	       
		    x++;
		
		}
		
		
		 
		//print
		System.out.println("\nEncraption");
	
		for (int i = 0; i < cyper.length; i++) {
			
			for (int j = 0; j < cyper[i].length; j++) {
				System.out.print(cyper[i][j]+ " ");
			}
			System.out.println();
		}
		
		
		return cyper;
		
	}
	
	
	public static void RowDe(char [][] text , String key)
	{
		int x =0;int k1; 
		
		char cyper[][]=new char[text.length][text[0].length];
		 
		while(x<key.length())
		{
			k1=Integer.parseInt(String.valueOf(key.charAt(x)))-1;
		 
			System.out.println();
		 
		    cyper[k1]=text[x];
	        
		    x++;
		
		}
		
		 
		//print
		System.out.println("\nDecrption");
	
		for (int i = 0; i < cyper.length; i++) {
			
			for (int j = 0; j < cyper[i].length; j++) {
				System.out.print(cyper[i][j]+ " ");
			}
			System.out.println();
		}
		
		
	 
		
	}
	
	
	
	public static char [][]  TextToArrayRow(String text , String key)
	{
	   
		text=ConCast(text);
		System.out.println(text+" -- > "+text.length());
		
		int r = key.length();
		int c=text.length()/r;
		
		
		double c1=(double)text.length()/r;
		if(c<c1)
		{
			c++;
		}
		
		int p=0;
		
		char txt [][]=new char[r][c];
		
		for (int i = 0; i < txt.length; i++)
		{ 
			for (int j = 0; j < txt[i].length; j++) 
			{
				
				if(p<text.length() &&  text.charAt(p) != ' ')
				{
					txt [i][j]=text.charAt(p);
	
				}
				else
				{
					txt [i][j]='x';
	
				}
				p++;
				
			}
		}
		
		
		
		for (int i = 0; i < txt.length; i++) {
			for (int j = 0; j < txt[i].length; j++) {
				System.out.print(txt[i][j]+" ");
			}
			System.out.println();
		}
		
		return txt;
		
		
		
		
	}
	
	
	
////////////////////////////////

	public static String ConCast(String text )
	{
	
		String x = "";
		for (int i = 0; i < text.length(); i++) {
		
		if(text.charAt(i) != ' ')
			{
				x +=text.charAt(i);
			}
		}
		
		return x;
	}
		 





}
