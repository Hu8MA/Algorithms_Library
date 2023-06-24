package lab;

public class RandRobin {

	static Data input []=new Data[5];
	static int cpu=0;
	static int k=2;
	static int compute_process=0;
	static int head=0;
	public static void main(String[] args) throws Exception {
		
		Data dt = new Data();
		input = dt.get_data();
		dt.print(input);
		bubbleSortForArrive(input);
		dt.print(input);
		int flag=-1;
		
		while(compute_process<5)
		{
             if(input[head].exe > 0 && input[head].ar2 <= cpu)
				{  
					rand(input,head);
					flag=0;
				 }
			 
			if(flag == -1)
			{
				cpu++;
			}
		}
		
		 	printstate(input, head);
			processrand(input);
			
			System.out.println("\n\n------+++++++++++++++++++++-------------"+cpu);
			dt.print(input);
	 	
	}
	
	private static void processrand(Data[] x) {

		for (int i = 0; i < x.length; i++) {
			
			x[i].wait = x[i].comple - x[i].Arrive - x[i].Burest;
			
			x[i].total=x[i].wait+x[i].Burest;
		}		
	}


	private static void rand(Data[] x, int c)
	{

		int t=0;
		
			while(t<k)
			{
				if(x[c].exe > 0)
				{
					cpu++;
					printstate(x,c);
					x[c].exe--;
					System.out.println("exe = "+x[c].exe);
					
					if(x[c].exe == 0)
					{
						x[c].stata="teredate";
						x[c].comple = cpu;
						compute_process++;
						head++;
					}
				 }
				t++;
			 }
			
			if(x[c].exe > 0)
			{
				x[c].stata="ready";
				x[c].ar2=cpu+1 ;
				bubbleSortForArrive(input);
				 

            }
	 }

	static Data [] bubbleSortForArrive(Data [] array) {
		  	
		   	int n = array.length;
		  	
		   	for (int i = 0; i < n - 1; i++)
		  	{
		  		for (int j = 0; j < n - i - 1; j++)
		  		{
		  			if(array[j].ar2 > array[j+1].ar2)
		  			{
		  				Data  temp= array[j];
		  				array[j]=array[j+1];
		  				array[j+1]=temp;
		  			}
		  			
		  		}
		  	}
		  	return array;
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
				else if(x[i].Arrive < cpu &&x[i].exe > 0)
				{
					x[i].stata="ready";
				}
		 	
				
			}
			
			
			 System.out.println("---------------------"+cpu);
			 for (int j = 0; j <input.length; j++)
			 {
				
				 System.out.println("P"+input[j].id +"  "+input[j].stata+"   e="+input[j].exe+"   a="+input[j].ar2);
			 }
			
		}





}
