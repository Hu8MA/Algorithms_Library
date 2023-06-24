import java.util.Scanner;

public class Binary_tree {

	
	 static Scanner read = new Scanner(System.in); static Node root;
	
	static class Node{
		int value;
		
		Node rigth;
		Node left;
		public Node( int data) {
			
	    value = data;
	    rigth = null;
	    left=null;
	    } }
	public static void main(String[] args) {

		
		 root = new Node(4);
		 
		 
		 System.out.println("");
		 System.out.println(""); 
		 System.out.println(""); 
		 System.out.println(""); 

	insertnode(root, 10);
	
	insertnode(root, 11);
	insertnode(root, 1);
	insertnode(root, 30);
	insertnode(root, 2);
	insertnode(root, 3);
	insertnode(root, 9);
	insertnode(root, -1);

         printBinaryTree(root, 0);
		
	}
	
	
	
	public static void add(Node root) {
		 int y=read.nextInt();
		 Node newnode=new Node(y);

		
		         if (root == null) {return;}
			
			if (newnode.value<root.value) {
				if (root.left == null) {
					root.left=newnode;}
				else {
				  add(root.left);}
				                          
			 }
			
			else if(newnode.value>root.value){
				if (root.rigth == null) {
					root.rigth=newnode; }
				
				else {
				      add(root.rigth);}   
			
			}  
			
	
	}

	


	public static void deleat(int y , Node root) {
				int x=y;
		
		if (root.left == null && root.rigth == null) {
			System.out.println("it can not found the value to delete ");
			return;
		}
		
		else if(true){
			
			if (x<root.value) {
				
				if (x == root.left.value) {
					root.left=null;
				}
				else {
					deleat(y, root.left);
				}	}
			
			 if (x>root.value) {
				if (x==root.rigth.value) {
                    root.rigth=null;
				}
				else {
					deleat(y, root.rigth);
				}
				}}}
	
	public static void sarch(int y , Node root) {
		int x=y;

if (root.left == null && root.rigth == null) {
	System.out.println("it can not found the value ");
	return;
}

else if(true){
	
	if (x<root.value) {
		
		if (x == root.left.value) {
	         System.out.println("is found");
		}
		else {
			sarch(y, root.left);
		}}
	
	 if (x>root.value) {
		if (x==root.rigth.value) {
         System.out.println("is found");
		}
		else {
			sarch(y, root.rigth);
		}		
	}}}

	
	public static void printBinaryTree(Node root, int level){
	    if(root==null)	{     
	    	
	    	return;   }

	    printBinaryTree(root.rigth, level+1);
	    
	    if(level!=0){
	    	
	        for(int i=0;i<level-1;i++) {
	            System.out.print("|\t");	}        
	        
	        System.out.println("|-------"+root.value);

	    }
	    else {
	        System.out.println(root.value);}

	    printBinaryTree(root.left, level+1);
	}
	
	
	
	
	private static void insertnode (Node current , int val)
	{
		
	 if (val <= current.value)   {
		 
	 if (current.left == null) 
		 
	 current.left = new Node (val) ;
	 else
		 
		 insertnode ( current . left , val) ; }
	 else
	 {
	 if (current.rigth == null)
	 
		 current.rigth = new Node (val) ;
	 else
		 insertnode ( current.rigth , val) ; }
	
	}
		

}

	


