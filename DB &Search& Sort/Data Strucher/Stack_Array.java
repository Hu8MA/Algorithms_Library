import java.util.Scanner;


public class Stack_Array {
	
	
static int array [] ; static int Top=-1; static Scanner read = new Scanner(System.in);
	
	
	

	public static void main(String[] args) {
	bulit_Stack();         boolean s = true;
		
		//System.out.println("\nshose 1 to Psh , 2 to Pop , 3 to print value of stack , 4 to end");

	Puh();
	Puh();
	
	Pop();
	
	Puh();
	Puh();
	
	Pop();
	Pop();
	
	Puh();
	Pop();

	
	/*push(2),
	 push(6), 
	pop(), 
	push(4)
	, push(3)
	, pop(),
	 pop(),
	 push(5)*/
getvalue();
	
	
	}
	
	public static void bulit_Stack() {
    System.out.print("Enter the length of Stack : ");
	array  =new int [read.nextInt()];  }
	
	
	public static void Puh() {

    	if (size()) {

    		Top++;

			System.out.print("\nEnter the value :- ");
			array[Top]=read.nextInt();  } 
 	else
		System.out.print("\nThe Stack is overflow can not do PUH ): ");}

	
    public static void Pop() {
    	
    	if (!(getTop() == -1)) {
    		System.out.print("\nThe element is delete "+array[Top]);
    	    Top--; }
    	else
    		System.out.print("\nThe Stack is empty can not do POP): ");}
   
    	

    public static void print() {
		System.out.println("\n------------------------ ");

    	if(!(getTop() == -1)) {
    	

    	for (int i=Top;i>=0;i--) {
    		
    		System.out.print(array[i]+" "); }}
    	else
    		System.out.print("\nThe Stack is empty not have any value"); }
    
    
    private static boolean size() {
    	
    	if (Top == array.length-1) {
    		return false; }
    	
    	else
    		return true; }
    
    private static int getTop() {
    	return Top;
    }
    
    public static void getvalue() {
    	
    	if(Top != -1) {
    		System.out.print("\nEnter the number of pointer ");
			int a=read.nextInt();boolean notfound=true;int i=0;int z=Top;
			if (a <=z) {
			
				while (notfound) {
				
					if (i==a) {
		System.out.print("The value is = "+array[i]);
		notfound=false;
					}
					else {
						i++;}
					
					
			         }
				if (notfound) {
	 				System.out.println("The array not have that value = " +a);	}
				
				
				}
			else
 				System.out.println("The pointer is out side ");	
			}
			
    	
    	else
    		System.out.println("The Stack is empty");
    
}
    


}