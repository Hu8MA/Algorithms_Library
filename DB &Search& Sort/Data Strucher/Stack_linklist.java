import java.util.Scanner;



public class Stack_linklist {

	
	static Scanner read = new Scanner(System.in);

	static link Top;	static int size;


	static class link{
		int value;
		
		link next;
		
		public link(int data , link next) {
			
	    value = data;
	    this.next = next; } }
	
	
	public static void main(String[] args) {
   bulit_stack();
   Push();
   Push();
   Push();
	System.out.println("-------------------------");

   print();
	System.out.println("\n-------------------------");

   Pop();
   Pop();
   Pop();
   Pop();
   Pop();


	System.out.println("\n-------------------------");

   print();

	System.out.println("-------------------------");

	}
	
	
	public static void bulit_stack() {
        
		System.out.print("enter the data of first node ");
		int x = read.nextInt();
		Top = new link(x,null);
		size=0;
	}
	
	
	public static void Push() {
		System.out.print("\nEnter the data of node ");
		
		link new_node = new link(read.nextInt(), null);
		new_node.next=Top;
		Top=new_node;
		size++;} 
	
	
	public static void Pop() {
		if (empty() == 1) {

		Top=Top.next;
		  System.out.println("\nPop is Done");
		  size--;}
		else
	    	 System.out.println("\nThe Stack is Empty can not do Pop");

		
	}
	
	public static void print() {
		
		link node=Top;
		if (empty() == 1) {
		while(node != null) {
			
			System.out.print(+node.value+" ");
			 node=node.next; }  }
		else
	    	 System.out.println("The Stack is Empty "); }

			
	
	public static int  size() {
		return size; }
	
	private static int empty() {
		if (Top == null) {
			return 0; }
		else 
			return 1;
	}

}
