package Algorthem_Sorting;

public class Selection_sort {

	public static void main(String[] args) {

		int []array = {30,80,10,50,22,7,100,9,300,1,-1,0,90};
	for (int i=0;i<array.length;i++) {
			
			System.out.print(array[i]+"  "); }
	
	
	System.out.println("\n----------------");
	System.out.println("----------------");

		select_sort(array, array.length);
		
		
	
		for (int i=0;i<array.length;i++) {
			
			System.out.print(array[i]+"  ");
		} }
	
	
	public static  void select_sort(int [] array , int length_of_array) {
		
		long x= System.currentTimeMillis();
		
		
		for (int i=0; i < length_of_array ; i++) {
			
			int mine = array[i];
			
			
			
			for (int j=i+1 ; j < length_of_array ; j++) {
				
				if (mine > array[j]) {
					array[i]=array[j];
					array[j]=mine;
					mine = array[i];}	
				
				
				/*
				 *   some example
				 *   when the array[i] have for example 30 
				 *   is save that value in mine , the mine  
				 *   It is compared with all sites,
				 *   and any site that contains the lowest value is exchanged with it,
				 *   but before that we must change the jealous value 
				 *   its location with the large value and 
				 *   then re-test to ensure the correct arrangement of the elements 
				 */
				   
				 }}
	

		}
	

}
