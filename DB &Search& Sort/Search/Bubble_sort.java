package Algorthem_Sorting;

public class Bubble_sort {

	public static void main(String[] args) {

		
		
		 int  [] array = {100,30,40,80,49,120,90};
		 
		 for (int i=0;i<array.length;i++) {
			 System.out.print(array[i]+" ");
		 }
		 Bubblesort(array, array.length);
		 
		 System.out.println("\n--------------------");
		 System.out.println("--------------------");

		 for (int i=0;i<array.length;i++) {
			 System.out.print(array[i]+" ");
		 }
				
	}
	
	
	static void Bubblesort(int array[],int lengthofarray) {
		
		for (int i=0;i<lengthofarray-1 ; i++) {
			
			for (int j=0;j<lengthofarray-i-1;j++) {
				
				if (array[j] > array[j+1]) {
					
					int temp = array[j] ;
					array[j]= array[j+1] ;
					array[j+1] =temp;
				}
				}
			}}





}
