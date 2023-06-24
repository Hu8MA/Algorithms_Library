package lab;

public class Next_fit {

	static int process[]= {150,200,650,120,300};
	static int memory[]= {100,500,600,250,750};
	static int c=0;
	static int no[]=new int [5];	
	static int t=0;
	public static void main(String[] args) {
	 
		System.out.println("memory");
		for (int i = 0; i < memory.length; i++) {
			System.out.print(memory[i]+" ");
		}
		
		System.out.println();
		for (int i = 0; i < process.length; i++)
		{
			for (int j = t; j < memory.length; j++) {
				if(process[i]<=memory[j])
				{
					memory[j]=memory[j]-process[i];						
					no[i]=j+1;
					t=j;
					if(t == memory.length-1)
					{
						t=0;
					}
					break;
				}}

		}
		
		
		
		
		
		   System.out.println("\nthe no of  located is \n");
					for (int i = 0; i < process.length; i++)
					{
						if(no[i]==0)
						{
							System.out.println(i+" "+process[i]+" -> no have  allocated");
						}
						else
						{
							System.out.println(i+" "+process[i]+" -> "+no[i]);
						}
				    }	
					System.out.println("\nmemory");
					for (int i = 0; i < memory.length; i++) {
						System.out.print(memory[i]+" ");
					}
	}

}
