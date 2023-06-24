package lab;

public class First_fit {

	static int process[]= {212,417,112,426};
	static int memory[]= {100,500,200,300,600};
	static int c=0;
	static int no[]=new int [4];	
	
	
	public static void main(String[] args) 
	{
	
			for (int i = 0; i < process.length; i++)
			{
				for (int j = 0; j < memory.length; j++) {
					if(process[i]<=memory[j])
					{
						memory[j]=memory[j]-process[i];						
						no[i]=j+1;
						break;
					}}
			 }			
	    System.out.println("\nthe no of  located is \n");
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
