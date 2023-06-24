import java.util.Scanner;


public class Queue_Array {

	static Scanner read = new Scanner(System.in) ; static int array [] ; static int Rear=-1,Front =-1;
	
	
	
	public static void main(String[] args) {
    built_Queue();
    
    Dequeue();
    Enqueue();
    Enqueue();
    Enqueue();
    Dequeue();
    Dequeue();

    print();
System.out.println("\n"+Front);
   // Dequeue();
   // Dequeue();
   // print();
	search_by_pointer();
	System.out.println("\n-----------------------------");
	search_by_data();	
		
	}

	
	public static void built_Queue() {
		
	System.out.print("Enter the size Queue = ");

	array = new int [read.nextInt()];
	System.out.println();
      }
	
	
	public static void Enqueue() {
		
		if (Rear ==	array.length-1)	{	
			
		System.out.print("\nIs Overflow So can not do Enqueue "); }
		
		else if (Front == -1) {
			Front=0 ; }
		
		System.out.print("\nEnter the value for Queue = ");
		
		Rear++;
		array[Rear]=read.nextInt();
	}
	
	 public static void Dequeue() {
		 
		 if (!(chack_empty())) {
			 System.out.print("\nThe Queue is Empty  So can not Do Dequeue ): "); }
		 
		 else {
              System.out.print("\nThe value is Delete ");
              chack_size();  }  
		 }
	 
	 public static void print() {
		 System.out.println("\n"+Front);
		 System.out.println("\n"+Rear);

		 System.out.println("\n------------------------------");

		 if (chack_empty()) {
			 System.out.print("\nThe value of Queue : ");

	     for (int i=Front ; i<=Rear ; i++) {
			 
		 System.out.print(array[i]+" "); }  }
		 
		 else {
			 System.out.print("\nThe Queue is Empty ): "); }
		 }
	 
	 private static void chack_size() {
			
			if (Front == Rear) {
				Front=-1;
				Rear=-1; }
			else {Front++;}
			}
		
		private static boolean chack_empty() {
			
			if (Front==-1) { 	
				return false; }
				else { 
					return true;}   
			}
		
		public static void search_by_pointer() {
			
			
			System.out.print("\nEnter the number of pointer ");
			int a=read.nextInt();
			
                 if (a <array.length) {
			
			for (int i=Front ; i<array.length ;i++) {
				
				if (i==a) {
					System.out.print("The value is = "+array[i]);
					}  }   }
				  else
     				System.out.print("\nThe pointer is out side the length of array ");	
		}
		
		public static void search_by_data() {
			System.out.print("\nEnter the data ");
			int a=read.nextInt();
			boolean found = false;int i=Front;
			while(!found && i<Rear) {
				
			if (array[i] == a) {
				System.out.print("The value is = "+array[i]+" Is inside pointer "+i);
                found=true;  } 
			
			else 
				i++;
			}
			if (!found) {
 				System.out.print("\nThe array not have that value = " +a);	}
	         }
		
		
		
		
		
		
}
