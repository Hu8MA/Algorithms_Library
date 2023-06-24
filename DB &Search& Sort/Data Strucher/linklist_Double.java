
import java.util.Scanner;



public class linklist_Double {

	
	
	static int n=5;static link head;static link teail;
	 static Scanner read = new Scanner(System.in);
		

	 static class link{
			int value;
			
			link after;
			link before;
			public link( link before  ,int data , link after ) {
				
		    value = data;
		    this.after = after;
		    this.before=before;
		    } }
	public static void main(String[] args) {

		 head=new link(null, 0, null);
		read();
		 print();
		 add_first(); 
		 print();
		 delete_first();
		 delete_first();
		 delete_first();

		 print();

		
		
		/*
		 * add_first();
		print();
		add_last();
		print();
		delete_first();
		print();
		delete_last();
		print();
		Removal_first();
		print();
		Removal_last();
		print();
		add_by_data();
		print();
		
		add_by_data1();
		print();*/
		
		
		
	}
	
	
	  static void read() {
	    	 link node = head;
			 for (int i=1;i<n;i++) {
				 System.out.println("enter the next node ");
				 
				 int x=read.nextInt();
				 
				 link newnode=new link(null,x,null);
	             node.after=newnode;
				 newnode.before = node;
				 node = newnode;
			 }
			 teail = node;
	     }
	     private static void print() {
		      
			 link node=head;
			 System.out.println("the linked list :- ");
			 while(node != null) {
				 
				 System.out.println(node.value);
				 node=node.after;
			 }
			 System.out.println("the link list is finsh (: ...."); }
	     
	     
	    
	     
	     
	     private static void print2() {
		      
			 link node=teail;
	    	
		

			 System.out.println("the linked list :- ");
			 while(node != null) { 
				 
				 System.out.println(node.value);
				 node=node.before;
			 }
			 System.out.println("the link list is finsh (: ...."); }
	     
	     
	     
	     
	     
	     private static void add_first() {
			 System.out.println("enter the first node :- ");
			 
			 int x=read.nextInt();
			 link first_node= new link(null,x,null);
			 first_node.after = head;
			  head.before=first_node;
			 head=first_node;
		 }
	     
	     private static void add_last() {
		     System.out.println("enter the last node :- ");
		 
		        int x=read.nextInt();
		         link last_node= new link(null,x,null);
		            link node=head;

		          while(node.after != null) {
				
		            	node=node.after;
		            	}
			         node.after=last_node;
			         last_node.before =node; 
			              node=last_node; 
			              teail=node;}
	     
	     private static void delete_first() {
			 
				link node = head ;
				
				node = node.after;
				
				head=node;
			 }
	     
	     private static void delete_last() {
	         
			 link node = head;
			 
			 while(node.after.after != null){
				 
				 node=node.after;
			 }
			 node.after=null;
			 }
	     
	     private static void  add_by_data() {
			 System.out.println("\nenter the value off node to add ");
				int add = read.nextInt();

				System.out.println("\nenter the value off node after ");
				int after_that = read.nextInt();
							
				link new_node = new link (null ,add , null);
				link p=head;
		       
		        for (int i=0; i < n && p.after != null ; i++) {
		        	
		        	if (p.value == after_that ) {
		        		link t = p.after;
		        		p.after=new_node;
		        		new_node.before=p.after;
		        		new_node.after =t;
		        		t.before=new_node;
		        		break; }
		        	else
		        		p=p.after;
		        	 }
		        if(p.after == null) {
		        	
		        	add_last();
		        }	}
	     
	     private static void  add_by_data1() {
			 System.out.println("\nenter the value off node to add ");
				int add = read.nextInt();

				System.out.println("\nenter the value off node after ");
				int after_that = read.nextInt();
							
				link new_node = new link (null ,add , null);
				link p=head;
		       
		        for (int i=0; i < n && p.after != null ; i++) {
		        	
		        	if (p.value == after_that ) {
		        		//link t = p.after;
		        		new_node.after=p.after;
		        		p.after=new_node;
		        		new_node.before=p;
		        		//new_node.after =t;
		        		//t.before=new_node;
		        		p=new_node;
		        		break; }
		        	else
		        		p=p.after;
		        	 }
		       	}  
	     

	   private static void Removal_first() {
		  
		   if (head != null) {
		   head=head.after;
		   head.before=null;
		   }
	   
		   else
			   System.out.println("you do not have node");
	   
	   }
	   
	   private static void Removal_last() {
	         
		   if (head != null) {
			   
			   teail =teail.before ;
			   teail.after = null ;

		   }
		   else
			   System.out.println("you do not have node");

	   }
	   
	   private static void  add_by_lection() {
	   
		   if (head !=null) {
			   System.out.println("enter the number of lection = ");
			   int a=read.nextInt();
			   
			   if(a == 1) {
				   add_first();
			   }
			   else if (a >= n ) {
	            add_last();
			   }
			   
			   else if(a >1 && a< n) {
			   System.out.println("enter the value of new node = ");
			   int value=read.nextInt();
				link new_node = new link (null ,value , null);
				link p=head;
	                    
				 for (int i=2 ; i<a;i++) {
					 p=p.after;
				 }
				 new_node.after=p.after;
	     		p.after=new_node;
	     		new_node.before=p;
	    		p=new_node;

			   }
			   
		   }
		   else
			   System.out.println("you do not have node ");

	}
	

}
