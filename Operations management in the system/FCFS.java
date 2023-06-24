package lab;

 

public class FCFS {

	static Data input [] = new Data[5];
	static int cpu=0;
	
	public static void main(String[] args) throws Exception {
		 
		Data dt = new Data();
		input = dt.get_data();
		dt.print(input);
		input = bubbleSortForArrive(input);
		dt.print(input);
		
		int c=0;
		while(c<5)
		{
			fcfs(c);
			c++;
		}
		

	}

	
	
	  
private static void fcfs(int c) {
		
		while(input[c].exe > 0)
		{
			cpu++;
			input[c].exe--;			
			printstate(input,c);
			
			System.out.println("the exe = "+input[c].exe);
		}
		
		if(input[c].exe <= 0)
		{
			input[c].stata="teredate";
		}
		
		
		
		 
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
