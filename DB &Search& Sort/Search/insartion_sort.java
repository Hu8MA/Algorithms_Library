package Algorthem_Sorting;

public class insartion_sort {

	public static void main(String[] args) {

		 int  [] array = {100,30,40,80,49,120,90};
		 
		 for (int i=0;i<array.length;i++) {
			 System.out.print(array[i]+" ");
		 }
		 insartionsort(array, array.length);
		 
		 System.out.println("\n--------------------");
		 System.out.println("--------------------");

		 for (int i=0;i<array.length;i++) {
			 System.out.print(array[i]+" ");
	}

}

	private static void insartionsort(int[] array, int length) {

		
	    for (int i=1;i<length;i++) {
	    	
	    	int key = array[i];
	    	int j=i-1;
	    	
	    	while(j >= 0 && array[j] > key) {
	    		
	    		array[j+1]= array[j];
	    		j=j-1;
	    		}
	    	array[j+1]= key;
	    }
	}
}