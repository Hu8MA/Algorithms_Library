package encraption;

import java.util.Scanner;

public class Vigenere {
	public static Scanner read = new Scanner(System.in);
	static char element []= {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	static int q[]=new int[40];
	static  int l=0;
	
	public static void main(String[] args) {
  
		String text="HusseinMhadi".toLowerCase();
		
		String key="RADIO".toLowerCase();
		
		int k[] =segmantkey(key);
		int t[] =segmanttext(text);
		
	    char c[]=	ecraption(t, k);
		
	    System.out.println("Encraption text : ");
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]+" ");
		}
		
		
		int cyper[] = segmantcyper(c);
		
		char plaint [] = descraption(cyper, k);
	    System.out.println("Descraption text : ");
	    
	    for (int i = 0; i < plaint.length; i++) {
			System.out.print(plaint[i]+" ");
		}
	    System.out.println("\ntext : ");
	    for (int i = 0; i < text.length(); i++) {
	    	 System.out.print(text.charAt(i)+" ");
		}

	}
	
	
	public static int [] segmanttext(String text ) {
		
		int c[]=new int [text.length()];
		
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < element.length; j++) {
			
				if(text.charAt(i) == element[j])
				{ 
					c[i]=j;
					j=element.length;
				}
			}
		}
		 
		return c;
		 
	}
	

	public static int [] segmantkey( String key  ) {
		
		int c[]=new int [key.length()];
		
		for (int i = 0; i < key.length(); i++) {
			for (int j = 0; j < element.length; j++) {
			
				if(key.charAt(i) == element[j])
				{ 
					c[i]=j;
				}
			}
		}
		 return c;
	}
	
	public static int [] segmantcyper(char[] cyper ) {
		
		int c[]=new int [cyper.length];
		
		for (int i = 0; i < cyper.length; i++) {
			for (int j = 0; j < element.length; j++) {
			
				if(cyper[i] == element[j])
				{ 
					c[i]=j;
					j=element.length;
				}
			}
		}
		 
		return c;
		 
	}
	
	public static char [] ecraption(int txt[] , int key[])
	{
		char cyper []= new char[txt.length];
		
		
		for (int i = 0; i < txt.length; i++) {
			
		  cyper[i]=element[	 ( ( txt[i]+key[(i%key.length)] )%26) ];
		  
		}
		 System.out.print("\n");
		return cyper;
		  
	}
	

     
    public static char [] descraption(int cyper[] , int key [])
    {
    	char plaint [] = new char [cyper.length];
    	
    	for (int i = 0; i < cyper.length; i++) {
    		plaint[i]=element[Math.abs(( cyper[i]-key[(i%key.length)] )%26)];
  		  
  		}
  		 System.out.print("\n");
  		return plaint;
  		  
    }
}
