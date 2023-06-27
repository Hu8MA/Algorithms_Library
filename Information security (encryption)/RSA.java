package Ecraption;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {

	static String x;

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		
		System.out.println("Enter the tow key & must be prime :) ");
		int n1=read.nextInt();
		int n2=read.nextInt();
		
		boolean t1=identifyPrime(n1);
		boolean t2=identifyPrime(n2);
	    System.out.println("n1 = "+t1 + "\n"+"n2 = "+t2);

	    
		
		if (identifyPrime(n1) && identifyPrime(n2))
	    {
			
		for (int i=0;i<10;i++) {
	      x=	Selection_of_keys(n1, n2);
	     System.out.println(x);
			}
	
		
			
		
		
			if (x != "") {
				
				for (int i=0;i<4;i++) {
	    	  System.out.println("\nmessage");
	    		 int m=read.nextInt();
	    		 System.out.println("n");
	    		 int n=read.nextInt();
	    		 System.out.println("e");
	    		 int e=read.nextInt();
	    		 
	    		 BigInteger x1= encryption(m, n, e);
	    	     System.out.println("\nencraption "+x1);

	    	     System.out.println("C <=> encraption msg");
	    	  	 double C=read.nextInt();
	    	  	System.out.println("n");
	    		  n=read.nextInt();
	    	  	 System.out.println("d <=>private key");
	    	  	 int d=read.nextInt();
	    	  	 
	    	  	BigInteger x2=descryption(C, n, d);
	    	       System.out.println("\ndesraption msg "+x2); 
				}
	     }}
	    
	    else { 
 	       System.out.println("is not prime ");}
		
		}
	
	
	static boolean identifyPrime(int x)
	{
		boolean flag=true;
		
		for (int i=2 ; i<= x/2 ; i++)
		{
			if (x%i == 0)
			{
				flag=false;
				break;
			}
		}
		
		if (!flag)
		{
			//"the number "+x+" not Prime";
			return flag; // false
		}
		 //"the number "+x+"   Prime";

			return flag; // true
		 
	}
	
	
	static String Selection_of_keys(int n1 , int n2)
	{
		int n=n1*n2;
		int euler=(n1-1)*(n2-1);
		
		int e=found_e(euler);
		
		int d=found_d(e,euler);
		if (d != -1) {
			
			return "euler = "+euler+" n = "+n+" e = "+e+" d = "+d;
		}
		else
			return "euler = "+euler+" n = "+n+" e = "+e+" d = not found";

	}
	
	
	static int found_e(int euler)
	{
		Random R = new Random();
	 
		boolean found=false;
		int e=0;
		
		while (!found)
		{
			 e = R.nextInt(200);
			
			   if (	identifyPrime(e) )
			   {
				   found =euler % e != 0 && e<euler ? true : false;
			   }
		}
		
		
		return e;
	
	}
	

	static int found_d(int e , int euler)
	
	{
		 int d=0;
		 Random R = new Random();		
		 boolean found=false;int i=0;

		 while (!found && i<150)
			{
			 d = R.nextInt(200);
			 

			 if (((d*e) % euler) == 1)
			 {
				 found=true;
			 }
			 i++;
			}

		 if (i==100)
		 {
			 return -1;
		 }
		 else
			 return d;
	
	}
	
	static BigInteger encryption(int msg , int n ,int e)
	{
		
		//System.out.println("----"+(Math.pow(msg, e)));
		BigInteger Msg=BigInteger.valueOf(msg);
		BigInteger N= BigInteger.valueOf(n);

		BigInteger C =(Msg.pow(e)).mod(N);
		System.out.println("is C = "+C);
		return C;
		
	}
	

	static BigInteger descryption(double c , int n ,int d)
	{
		
		BigInteger N= BigInteger.valueOf(n);
		BigInteger C = BigDecimal.valueOf(c).toBigInteger();
		BigInteger M= (C.pow(d)).mod(N);
		System.out.println("is M = "+M);
		return M;
	}
	

}
