import java.util.Scanner;


public class Queue_Linklist {

	static Scanner read = new Scanner(System.in); static link Rear,Front ;static int size;
	
	static class link{
		int value;
		
		link next;
		
		public link(int data ) {
			
	    value = data;
	     } }

	
	
	public static void main(String[] args) {
      Built_link();		
      
      Dequeue();
      Enqueue();
      Enqueue();
      Enqueue();
      Dequeue();
      Dequeue();
System.out.println();
     


      print();
      search_by_pointer();
    //  search_by_data();
      /*
       * enqueue(3),
 enqueue(5),
 enqueue(1),
 dequeue(),
 enqueue(4),
 dequeue(), 
dequeue(), 
enqueue(7)

*
*--------------------
*dequeue(),
 enqueue(x), 
enqueue(y),
 enqueue(z),
 dequeue(),
 dequeue() */
   
	}
	
	public static void Built_link() {
		Rear=null;
		Front=null;
		size=0;
	}
	
	
	public static void Enqueue () {
	     System.out.print("\nEnter the value = ");
			link new_node=new link(read.nextInt());

            if (Front == null && Rear == null) {
            	Front=new_node;
            	Rear=new_node; }
        else {
		Rear.next=new_node;
		Rear=new_node;
		}
            size++; 
       }


	public static void Dequeue() {
		
	if (Front == null) {
		System.out.print("\nThe Queue is empty So can not Do dequeue "); }
	
	else {
		if (Front == Rear) {
			Front=null;
			Rear=null; }
		else {System.out.println(Front.value);
			Front=Front.next;
		    } size--; } 
	
	 }
	
	private static void chack_size() {
		
		if (Front == Rear) {
			Front=null;
			Rear=null; }
		else {Front=Front.next;}
		}
	
	
	public static int get_size() {
		return size; }
	
	
	public static void print() {
		System.out.println("------------------------");
		if (Front == null) {
			System.out.print("The Queue is empty "); 
		}
		else {
			link node=Front;
			System.out.print("\nThe value of Queue : ");

			while(node != null) {
				 
				 System.out.print(node.value+" ");
				 node=node.next;
			 }}
		System.out.println("\n------------------------");
        }
	
	
	public static void print2() {
		System.out.println("\n------------------------");

		if (Front == null) {
			System.out.print("The Queue is empty "); 
		}
		else {
			link node=Front;

			 System.out.print("\nThe value of Queue : ");

			for(int i=1;i<=size;i++) {
				System.out.print(node.value + " ");
				node=node.next; }	}
		}
	
	
	public static void search_by_pointer() {
		
		
		if(Front != null) {
			System.out.print("\nEnter the opation of node ");
			int a=read.nextInt();
		if (a == 1) {
			 System.out.println (Front.value); }
		else if(a == size){ 
			System.out.print("\n the value = "+Rear.value);
			
		}
			
		
		else {
			link node=Front;
			for (int i=2;i<=a  && node.next != null ; i++) {
				 
				 node=node.next;}
		      if (node.next == null) {
			 System.out.println("the node is not in the link  ... ");  }
	 
		else {
		 System.out.println("The value of node is = "+node.value);} }
		}
		
		else
			System.out.print("\the link list is empty ..");
		}
	
	
	  public static void search_by_data() {
		if(Front != null) {
			System.out.print("\nEnter the opation of node = ");
			
			int a=read.nextInt(); boolean found = false;  link node = Front;int i=1;
			while (!found && node.next !=null) {
				
			if(a == node.value) {
				System.out.print("\nThe link is have "+a+" inside node = "+i);
				found=true;
			}
			
			else {node=node.next;i++;}
			
			}
			if (!found) {
				System.out.print("\nThe link not have that value = " +a); }
			 }
		else
			System.out.print("\the link list is empty ..");
		}

}
