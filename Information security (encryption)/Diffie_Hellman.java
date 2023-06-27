package Ecraption;

import java.math.BigInteger;
import java.util.Scanner;

public class Diffie_Hellman {

	static int primative [];
	static Scanner read =new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.println("enter the number of Q & must be prime");
		int q=read.nextInt();
		boolean x=identifyPrime(q);
		System.out.println((x == true) ? "true "+ q +" is prime" : "false "+ q+" is not prime");
		
		primative=new int[(int)q-1];
		
		System.out.println("\nenter the number of a & must br primativ of Q");

		int a=read.nextInt();
		if(a<q) {
		claclate(a, q, primative);
		boolean x1=is_primativ(primative);
		System.out.println((x1 == true) ? "true "+ a+"  is primativ " : "false "+ a +" is not primative ");
		
	    //////////////////////////
		System.out.println("\n\nenter the private key of manA & must be < Q");
		
		int nA=read.nextInt();
		
		BigInteger k1= claclate_key_of_manA(a, q,nA); 
	   
	    
	    System.out.println("\n\nenter the private key of manB & must be < Q");
	    
		int nB=read.nextInt();
	     BigInteger k2= claclate_key_of_manB(a, q,nB); 
	    
	     ////////////////////////////////
	     System.out.println("\n\n find secrt key for manA & manB ");
	     find_secret_key_of_manA(k2, nA, q);
	     find_secret_key_of_manB(k1, nB, q);
		  
		}
		
		else {
			System.out.println("must be a<q");
		}
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
	
	
	private static void print(int primative []) {

		for (int i=0;i<primative.length;i++) {
			System.out.print(primative[i]+"  ");
		}
		System.out.println("\n");

	}



	static void claclate(double a ,double q , int primative[]) {
		
		boolean found=true;
	
		for (double i=0;i<primative.length;i++){
			//System.out.println(i+"<--->"+(Math.pow(a,i))+"  "+ "%  "+ q+"  => "+(Math.pow(a,i))%q);

			if (((Math.pow(a,i))%q) < q) {
			primative[(int)i]=(int)((Math.pow(a,i))%q);
			}
		}
		
		}
	
	
		
	static boolean is_primativ(int primative[]) {
			
		boolean found=true;
		for (int i=0;i<primative.length;i++) {
			
			
			for (int j=i+1;j<primative.length;j++) {
				
				if (primative[i]==primative[j]) {
					found=false;
					System.out.println("value index i "+ i + " = " +" value index j " + j);
					break;
				}	}}
		
		return found;
		}
		
		
	static BigInteger claclate_key_of_manA(int a,int q , int nA) {
		
		System.out.println("the private key for manA is "+nA);
		BigInteger A=BigInteger.valueOf(a);
		
		BigInteger Q= BigInteger.valueOf(q);
		BigInteger K1=(A.pow(nA)).mod(Q);
		
		System.out.println("the k1 key for manA is "+K1);
		
		return K1;
		
	}
		
	static BigInteger claclate_key_of_manB(int a,int q,int nB) {
		
		System.out.println("the private key for manB is "+nB);

		
		BigInteger A=BigInteger.valueOf(a);
		
		BigInteger Q= BigInteger.valueOf(q);
		BigInteger K2=(A.pow(nB)).mod(Q);
		
		System.out.println("the k2 key for manB is "+K2);

		return K2;
		
	}
	
  
	static void find_secret_key_of_manA(BigInteger K2,int nA ,int q) {
		
		BigInteger Q= BigInteger.valueOf(q);
		
		BigInteger secretkey=(K2.pow(nA)).mod(Q);
		
		System.out.println("the secret key of manA is "+secretkey);
	}
	
	static void find_secret_key_of_manB(BigInteger K1,int nB ,int q) {

		BigInteger Q= BigInteger.valueOf(q);

		BigInteger secretkey=(K1.pow(nB)).mod(Q);
		
		System.out.println("the secret key of manB is "+secretkey);
	}
	

}
