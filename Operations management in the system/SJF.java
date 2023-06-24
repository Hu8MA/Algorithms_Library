package lab;

public class SJF {

	static Data input [] = new Data[4];
	static int cpu =0;
	static int compute_process=0;

	
	public static void main(String[] args) throws Exception 
	{
		Data dt = new Data();
		input = dt.get_data();
		dt.print(input);
		input=bubbleSortForArrive(input);
		dt.print(input);
		
	 //to solve the problem of ideal , if have ideal in first process
		int min=999; int c=-1;
		while(c == -1)
		 {
			 for (int i = 0; i < input.length; i++) 
			  {
				   if(  input[i].Arrive <= cpu   && input[i].exe>0 && input[i].Burest < min)
					  {
						  c = i;
						  min=input[i].Burest ;
						  
					  }	
		       }
			 if(c == -1)
			 {
				 cpu++;
			 }
		 }
		
		 //to solve the problem of ideal , if have ideal in first process
		
		
		 while(compute_process<input.length)
		{
			 if(c != -1)
			    {
			       c=sjf(c);
			    }
		 	 //that mean the process is finish , and the cpu need the new process to run
			   if(compute_process<input.length) 
			   { 
					c=-1;min=999;
					for (int i = 0; i < input.length; i++) 
					  {
						   if(input[i].Arrive <= cpu && input[i].stata != "teredate" && input[i].exe < min)
							  {
								  min = input[i].exe;
								  c=i;
							  }
					  }
					
					//that mean in this time not have the new process ,is ideal
					if(c == -1)
					{
						cpu++;
					}
	 		   }
	 	}
		
		processSjf(input);
		
		System.out.println("\n\n------+++++++++++++++++++++-------------");
		dt.print(input);
 	}
	
	static void processSjf(Data x[])
	{
		for (int i = 0; i < x.length; i++) {
			
			x[i].wait = x[i].comple - x[i].Burest - x[i].Arrive;
			
			x[i].total=x[i].wait+x[i].Burest;
		}
	}
    static int sjf(int c)
	  {
 		
		while(input[c].exe > 0)
		{
					cpu++;
					printstate(input, c);
				 	input[c].exe--;
				    System.out.println("exe "+input[c].exe);
				    if(input[c].exe == 0)
					   {
						  input[c].comple=cpu;
						  input[c].stata="teredate";
						  compute_process++;
						  printstate(input, c);

					   }
				    
				    //is use in preemptive
				    for (int i = 0; i < input.length; i++) 
					{
					   if(input[i].Arrive <= cpu && input[i].stata != "teredate" && input[i].exe <input[c].exe)
						 {
							     input[c].stata="ready";
								 c=i;
						  }
					}
	 	  }
	   return c;
	
	}
    private static void printstate(Data[] x,int c ) {

			for (int i = 0; i < x.length; i++)
			{
				if(x[i].Arrive == cpu)
				{
					x[i].stata="new";
				}
				else if(x[i].Arrive < cpu && i==c && x[i].exe > 0)
				{
					x[i].stata="run";
				}
				else if(x[i].exe <=0)
				{
					x[i].stata="teredate";
				}
				else if(x[i].Arrive < cpu && x[i].stata != "teredate")
				{
					x[i].stata="ready";
				}
		  	}
			
			
			 System.out.println("---------------------"+cpu);
			 for (int j = 0; j <input.length; j++)
			 {
				
				 System.out.println(input[j].id +"  "+input[j].stata);
			 }
			
		}
    static Data [] bubbleSortForArrive(Data [] array) {
	  	
	   	int n = array.length;
	  	
	   	for (int i = 0; i < n - 1; i++)
	  	{
	  		for (int j = 0; j < n - i - 1; j++)
	  		{
	  			if(array[j].Arrive > array[j+1].Arrive)
	  			{
	  				Data  temp= array[j];
	  				array[j]=array[j+1];
	  				array[j+1]=temp;
	  			}
	  		}
	  	}
	  	return array;
	  }
 
 
}
