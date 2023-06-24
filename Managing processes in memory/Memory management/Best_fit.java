package lab;

public class Best_fit {

	static int process[]= {212,417,112,426};
	static int memory[]= {100,500,200,300,600};
	static int c=0;
	static int x=1000;
	static int p=-1;
	static int no[]=new int [4];	
	
	public static void main(String[] args) 
	{
 
		for (int i = 0; i < process.length; i++)
		{
			for (int j = 0; j < memory.length; j++)
			{
				if(process[i]<=memory[j] && (memory[j]-process[i])<x)
				{
					 x=memory[j]-process[i];
					 System.out.println(j+"->"+x);
					 p=j;
				}
				
				
				
			}
			if(p>-1)
			{
				memory[p]=memory[p]-process[i];
				no[i]=p+1;
				p=0;
				System.out.println("P"+i+" -> "+no[i]);
				x=1000;
				for (int j = 0; j < memory.length; j++) {
					System.out.print(memory[j]+" ");
				}
				System.out.println();
			}
		
			
		 }	
		
		
		//////////////////////////
		
    System.out.println("\n\n\nthe no of  located is \n");
		for (int i = 0; i < process.length; i++)
		{
			if(no[i]==0)
			{
				System.out.println(i+" -> no have  allocated");
			}
			else
			{
				System.out.println(i+" -> "+no[i]);
			}
	    }	
		
	}

}
