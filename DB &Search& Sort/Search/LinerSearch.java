package Defult;

import java.util.Scanner;

public class LinerSearch {
	
 
 static Scanner read = new Scanner(System.in);
	/*
		 
		 linear Search 
		 
		 1- Input the data structure
		 
		 2- Get the Key from user
		 
		 3- put the Key in Function by Parameter
		 
		 4- make for loop begin first_location to last_location
		 
		 5- make condition by if the value of the location Equal the key value && must the pointer not out of range structure
		   
		   a- true : return the location of this value in structure or print the message for user
		   
		   b- false : return -1 or print message for the user
		   
		 6- finish the Algorithm
		  
		 
	 */
	public static void main(String[] args) {

		
		int Array [] = {1 ,2 ,-9 , 3 , 4, 5, -63, 6 , 7 ,8 , 0 ,32 , 94, -1};
		
		
		System.out.print("Enter the Key to Search = ");
		
		int key = read.nextInt();
		
		System.out.println('\n');

	
		
		int Out = Search (Array , key);
		
		if (Out != -1){System.out.println("the value is found in location = " + Out);}
		
		else{ System.out.println("the value is not found in Structure " );}
		
	}
	
	
	
	public static int Search(int [] Array , int key ) {
		
		int i=0; 
		
		while(i < Array.length)	
		{
			
				 if (Array[i] == key) {  return i; }
				 
				  i++;
        }
	 
       return -1;			
 	 	
	}

}
