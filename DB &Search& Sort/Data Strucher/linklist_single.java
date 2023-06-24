import java.util.Scanner;


  public class linklist_single {

	
		static Scanner read = new Scanner(System.in);

	static int n;static link head;


	static class link{
		int value;
		
		link next;
		
		public link(int data , link next) {
			
	    value = data;
	    this.next = next; } }


	
	public static void main(String[] args) {

		System.out.println("enter the No. of nodes ");
		
		n= read.nextInt();
		System.out.println("enter the data of head ");
		int x = read.nextInt();
		head = new link(x,null);
		
		read();  
		print( ); // void
	    delete_first();   // void
	    print( ); 
		delete_last();   // void
		print( ); 
		delete_data();   // void
		print( ); 
		delete_opation(); // void
		print( ); 
		add_first();      // void
		print( ); 
	    add_last();       //void
	    print( ); 
		Scarch_data();    // void
		print( ); 
		Scarch_opation(); // void
		print( ); 
		add_by_data();    // void
		print( ); 
		add_by_pointer(); // void
		print( ); 
		length_list();    // int 
		print( );         // void

		
	}

	
 private static void read() {
		 
		 link node = head;
		 for (int i=1;i<n;i++) {
			 System.out.println("enter the next node ");
			 
			 int x=read.nextInt();
			 
			 link newnode=new link(x,null);
             node.next=newnode;
			 node=newnode;
		 } }
	
	private static void delete_first() {
		 
			link node = head ;
			
			node = node.next;
			head=node;
		 }
	 
	 private static void delete_last() {
          
		 link node = head;
		 
		 while(node.next.next != null){
			 
			 node=node.next;
		 }
		 node.next=null;
		 }

   
	
    private static void add_first() {
		 System.out.println("enter the first node :- ");
		 
		 int x=read.nextInt();
		 link first_node= new link(x,null);
		 first_node.next = head;
		 head=first_node;
	 }
	
   private static void add_last() {
		     System.out.println("enter the last node :- ");
		 
		        int x=read.nextInt();
		         link last_node= new link(x,null);
		            link node=head;

		          while(node.next != null) {
				
		            	node=node.next;}
		          
			         node.next=last_node;
			              node=last_node;  }
	
	 private static void delete_opation() {
		
		     if (head !=  null) {
			 
			 System.out.println("enter the opation node to delete :- ");
				int opation = read.nextInt();
				
				if(opation <n && opation >0) {
					
					if (opation == 1) {
						delete_first();
					}
					
					else {
						link newnode = head;
					
			 for (int i=1;i<opation -1 && newnode.next != null ; i++) {
				 
				 newnode=newnode.next;
			 }
			 
			 if (newnode.next != null) {
			 newnode.next=newnode.next.next;}
				
		           else 
			 System.out.println("the opation is not been into link ");
	             	}}
				else 
					 System.out.println("the opation is out the range ");
		         }
		       else 
			      System.out.println("the link is empty ");

		     }
	 
	 private static void delete_data() {
		 if (head !=  null) {
			 System.out.println("enter the data node to delete :- ");
				int node_data = read.nextInt();
				if(head.value == node_data) {
					
					delete_first();}
				
				else {
				
				link newnode = head;
				
				while ( newnode.next.value !=node_data && newnode.next != null) {
					
					newnode = newnode.next;
						}
				if (newnode.next == null) {
					System.out.println ("is not found ... ");}

				else {
					 newnode.next= newnode.next.next;
				}
				}}
		 
		    else {
		        	 System.out.println("the link is empty .... :("); }
		       }
		
	
    private static void  Scarch_data() {
		

		 System.out.println("enter the value of node to return opation ... ");
		 
		 int node_data = read.nextInt();
			
		 if(head.value == node_data) {
			 
				System.out.println( 1) ;	}
		 
		 else if (true) {
			 link newnode = head; int i=2; 
			 while (newnode.next.value !=node_data &&  newnode.next != null) {
					newnode = newnode.next;
                    i++; }
		 
			 if (newnode.next == null) 
					System.out.println ("is not found ... ");

				else 
					
					System.out.println( i) ; }
		 else 
				System.out.println ("is not found ... "); }
	 
	 
	 private static void  Scarch_opation() {
		 if (head !=  null) {


		 System.out.println("enter the opation of node to return value ... ");
		 
		 int opation = read.nextInt();
			
		 if(opation <n && opation > 0) {	
			 
			 if (opation == 1) {
				 System.out.println (head.value);
			 }
		 
			 else {
				 link newnode = head;

				 for (int i=1;i<opation -1 && newnode.next != null ; i++) {
					 
					 newnode=newnode.next;
				 }
				 
				 if (newnode.next == null) {
					 System.out.println("the node is not in the link  ... ");
					 }
					
			 else {
				 System.out.println(newnode.value);}
			}
			 }}
		 
		 else
			 System.out.println("the link is empty ... ");
		 
	 }
	 private static void  add_by_data() {
		 System.out.println("\n enter the value off node to add ");
			int add = read.nextInt();

			System.out.println("\nenter the value off node after ");
			int after = read.nextInt();
			
			link new_node = new link (add , null);
			link p=head;
	       
	        for (int i=0; i < n && p.next != null ; i++) {
	        	
	        	if (p.value == after ) {
	        		new_node.next =p.next; 
	        		p.next=new_node;
	        		break;}
	        	else
	        		p=p.next;
	        	 }
	        if(p.next == null) {
	        	
	        	add_last();
	        }	}
	 private static void  add_by_pointer() {
		 System.out.println("\n enter the value off node to add ");
		    int add = read.nextInt();

		     System.out.println("\nenter the pointer off node after ");
			int pointer = read.nextInt();
			
		 if (pointer < n && pointer >0) {
			link new_node = new link (add , null);
			link p=head;
	       
	        if (pointer == 1 ) {
	        	
	        	add_first(); }
	        
	        else {
	        	for (int i=1 ; i<pointer && p.next !=null ; i++) {
	        	
	        		p=p.next;}
	        	
	    	new_node.next = p.next;
    		p.next = new_node;}}
		 else {
			 System.out.println("You enter pointer bigger of length the lest .... :( ");
		 }
	 }
	 
	 private static int length_list() {
			link p=head;int counter = 0 ;
		if (p.next != null) {
			while (p.next !=null) {
				counter++;
				p=p.next;
			}
		}
		else {System.out.println("You do not have lest .... :( ");}

		return counter;
	 }
	 
	 private static void print() {
	      
		 link node=head;
		 System.out.println("the linked list :- ");
		 while(node != null) {
			 
			 System.out.println(node.value);
			 node=node.next;
		 }
		 System.out.println("the link list is finsh (: ...."); }
}
