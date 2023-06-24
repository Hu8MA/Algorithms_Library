package AllClassForTrees;

import java.lang.Math;



public class BinarySarchTree { 		static int i=0;static boolean f=true;static nodetree root;

	
	static class nodetree {
		int value;
		nodetree Rigth;
		nodetree left;
		
		nodetree(int a){
			value=a;
			Rigth=null;
			left=null;
		}}


    
	public static void main(String[] args) {
		
		
	 root = new nodetree(40);
	   add(root, 30);
	   add(root, 80);
	   add(root, 20);
	   add(root, 35);
	   add(root, 75);
	   add(root, 86);
	   add(root, 18);
	   add(root, 22);
	   add(root, 32);
	   add(root, 37);
	   add(root, 71);
	   add(root, 77);
	   add(root, 83);
	   add(root, 90);



	   
	   System.out.println("----------------------------\n");


	   printBinaryTree(root,0) ;  
	   System.out.println("-------------After deleted---------------\n");
	
	   delete_node(root, 40);
	   
	   
	   System.out.println("----------------------------\n");
	   printBinaryTree(root,0) ;  

	  

	
	}

	
	 static void add(nodetree newnode , int x){
		 
		 if(newnode == null) {
			 return;
		 }
		 else if (newnode.value > x) {
			 
			 if (newnode.Rigth == null) {
				 newnode.Rigth=new nodetree(x);  }
			  else {
				 add(newnode.Rigth, x); }   }
		 
		 else if (newnode.value <= x) {
			
			 if (newnode.left == null) {
				 newnode.left=new nodetree(x); }
			 else {
				 add(newnode.left, x);}   }	
	}

	 
	 static void  treverser_pre(nodetree node) {
		 if (node != null) { 
	 
		
			System.out.print(node.value+" ");
		 
			 treverser_pre(node.Rigth);
		     treverser_pre(node.left);
		 }
		 }
	  
 static void treverser_In(nodetree node) {
		 
		 if (node == null) { return ;}
	 
		 else {
			 treverser_pre(node.left);
			 System.out.print(node.value+" ");
			
			 treverser_pre(node.Rigth);
		
		 }}
 
 static int  countofnoodfortree(nodetree root) {
	 
	 
	 if (root != null) {
         i++;
 countofnoodfortree(root.left);			
 countofnoodfortree(root.Rigth);
 }	 
return i;	 
 }
 
 
 static int countlevel() {
	 int x=countofnoodfortree(root);
	 int  b =(int)(Math.log(x)/Math.log(2));
	 return b;
 }
 
		 
  static void printBinaryTree( nodetree root, int level){
	    if(root==null)	{     
	    	
	    	return;   }
        printBinaryTree(root.Rigth, level+1);
	    
	    if(level!=0){
	    	
	        for(int i=0;i<level-1;i++) {
	            System.out.print("|\t");	}        
	        
	        System.out.println("|------- "+root.value);
	          }
	    else {
	        System.out.println(root.value);}
            printBinaryTree(root.left, level+1);
	} 
  
  
	
     static void sarch(int y , nodetree root) {
		int x=y;
			
			if (root.left == null && root.Rigth == null) {
				System.out.println("it can not found the value ");
				return;
			}
			
			else if(true){
				
				if (x == root.value) {
			       System.out.println("is found");
			       }
				if (x >root.value) {
					
					if (x == root.left.value) {
				         System.out.println("is found");
					}
					else {
						sarch(y, root.left);
					}}
				
				 if (x < root.value) {
					if (x == root.Rigth.value) {
			         System.out.println("is found");
					}
					else {
						sarch(y, root.Rigth);
					}		
				}}}
     
     
	
	 static int min_number(nodetree root) {
		nodetree e=root;
		
		while (e.Rigth != null) {
			
			e=e.Rigth;  }
		
		return e.value;	}
	 
	 
	 
	 
    static int  max_number(nodetree root) {
	nodetree e=root;
		
		while (e.left != null) {
			
			e=e.left;  }
		
		return e.value;
	}
    
    
    
    
    static void delete_node_leaf(nodetree root , int nm) {
    	nodetree e = root;boolean d = false;
    	
    	if (nm >e.value) {
    		
    			if (nm == e.left.value) {
    			
    			if (e.left.left == null && e.left.Rigth == null) {
    			
             
    			e.left=null;
   			 System.out.println("is deleted leaf");
   			 d=true;

    		}
    			else{
    				System.out.println("is not leaf :(");}
    			}
    		
    		else {
    			delete_node_leaf(e.left, nm);
    		
    		
    		}}
    	
    	 if (nm <= e.value) {
    		
    		 if ( e.Rigth.value == nm) {
     			if (e.Rigth.left == null && e.Rigth.Rigth == null) {


    			 e.Rigth=null;
    			 System.out.println("is deleted leaf");
       			 d=true;

    		 }
     			else{
 				System.out.println("is not leaf :(");}
 			}
 		
    		 else {
    			 delete_node_leaf(e.Rigth , nm); }	
    		 }	
    	
       if (d == true) {
    	   root=e;
       }
      }
    
    
    static void delete_node(nodetree root , int nm) {
    	
    	
    	nodetree e = root;boolean d = false;nodetree temp;
    	
    	if (nm == e.value) {
    		temp=e.Rigth;
    		int x=max_number(temp);
    		e.value=x;
    		delete_node_leaf(temp, x);
    		d=true;
    	}
    	else {
    	
    	if (nm >e.value) {

     		if (nm == e.left.value) {
    			temp=e.left;

    			if ((temp.left != null)&&(temp.Rigth == null)){
    				
    				e.left = temp.left;
    				 System.out.println("is deleted");
    	   			 d=true; }
    			
    			else if((temp.left == null && temp.Rigth != null)) {
    				e.left = temp.Rigth;
   				 System.out.println("is deleted");
   	   			 d=true; 
    			}
    			
    			else if (temp.left != null && temp.Rigth != null){
    				nodetree t=temp.Rigth;
    				
    				if (t.left != null && t.Rigth != null) {
    				int x = max_number(t);
    				delete_node_leaf(t, x);
    				e.left.value=x;
    				 System.out.println("is deleted");
       	   			 d=true; 
    			}
    				else{
    					int x = t.value;
    					temp.value=t.value;
    					e.left=temp;
       				 System.out.println("is deleted");
          	   			 d=true;
          	   	       delete_node_leaf(temp, x);
    					}
    				}
    		}
    		
    		
    		else {
    			delete_node(e.left, nm);
    		
    		}}
    	
    	/////////////////////////////////////////////////
    	
    	 if (nm < e.value) {

    		
    		 if ( e.Rigth.value == nm) {
    	 			temp=e.Rigth;

    				if ((temp.left != null)&&(temp.Rigth == null)){

        				e.Rigth = temp.left;
        				 System.out.println("is deleted");
        	   			 d=true; }
        			
        			else if((temp.left == null && temp.Rigth != null)) {
        				e.Rigth = temp.Rigth;
       				 System.out.println("is deleted");
       	   			 d=true; 
        			}

        			else if (temp.left != null && temp.Rigth != null){
        				nodetree t=temp.Rigth;
        				
        				if (t.left != null && t.Rigth != null) {
        				int x = max_number(t);
        				delete_node_leaf(t, x);
        				e.Rigth.value=x;
        				 System.out.println("is deleted");
           	   			 d=true; 
        			}
        				else{
        					int x = t.value;
        					temp.value=t.value;
        					e.Rigth=temp;
           				 System.out.println("is deleted");
              	   			 d=true;
              	   	       delete_node_leaf(temp, x);
        					}
        				}
    				}
 
    		 else {
    			 delete_node(e.Rigth , nm);
    		}		  	 }
    	}
	 
       if (d == true) {
    	   root=e;   }
       
    }	 
}