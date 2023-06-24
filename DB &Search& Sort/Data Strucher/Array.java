import java.util.Scanner;

public class Array {
	
	 static int length;static int array[];static int size = 0;

	public static void main(String[] args) {

		array=new int[20];
		array[0]=0;
		
 		read(8);
 		read(2);
 		read(4);
 		read(0);
 		read(-1);

 		print();
 		aroder();
		System.out.println("");

 		print();
 		
 		System.out.println("");
        insert(6);
 		print();
 		System.out.println("");


 		search2();
 		}
	
	public static void read(int a) {
		
		if (size<array.length) {
			array[size]=a;
			size++;
		}
		else
			System.out.println("is overflow");

	}

	public static void aroder () {
		
		int temp=0;
		
		  for (int i = 0; i <size; i++) {   
	            for (int j = i+1; j <size; j++) {   
	               if(array[i] > array[j]) {  
	                   temp = array[i];  
	                   array[i] = array[j];  
	                   array[j] = temp;  
	               }   }   }  
	}
	
	
	
	
	public static void insert(int x) {
		
		if (size < array.length) {
			int i=size-1;
			while (i>0 && x<array[i]) {
				array[i+1]=array[i];
				i=i-1; 
				}
			array[i+1]=x;
			size++;
			}
			
		
		else
			System.out.println("is overflow");
	}
	
	
	public static void print() {
		
		for (int i=0;i<size;i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	
	public static int  sarceh(int y) {
		boolean found=false;
        int i=0;
          
          while (!found) {
        	  if (array[i]==y) {
        		  found=true;
        	  }
        	  else
        		  i++;
          }
          
          if (found) { 
        	  return 1;}
          else
        	  return -1;

	}
	
	public static  void search2(){
		int flag=0;
		
		Scanner input=new Scanner (System.in);
		
		System.out.println("enter element to search");
		int key=input.nextInt();
		for(int i=0;i<size;i++){
			
			if(array[i]==key)
			{
				System.out.println("element "+key+" found at "+i+" position");
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("element"+key+"notfound ");
		}
	
	

}
	
}
