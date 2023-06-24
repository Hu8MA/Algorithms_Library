package lab;

import java.io.BufferedReader;
import java.io.FileReader;

public class Get_Data_FromFile {
	public   int id;
	public   int Arrive;
	public   int Burest;
	public   int wait;
	public   int total;
	public   int exe;
	public   int comple;
	public   String stata;
	public   int pro;
	public   int ar2;
	
	public   Get_Data_FromFile(int id , int arrive , int burest , int wait , int total , int exe , int comple,String stata,int pro,int ar2) {
		this.id=id;
		this.Arrive=arrive;
		this.Burest=burest;
		this.wait=wait;
		this.total=total;
		this.exe=exe;
		this.comple=comple;
        this.stata=stata;
        this.pro=pro;
        this.ar2=ar2;
	}
	
	public   Get_Data_FromFile() {
		 
	}
	
	public Get_Data_FromFile[] get_data() throws  Exception {
		
		  String line ="";   String value[]=null;
		  
		  FileReader x = new FileReader("D:\\lab2.csv");
		  
		  BufferedReader read=new BufferedReader(x);
		  
		  Get_Data_FromFile  data [] =new Get_Data_FromFile[5];
		  
		  int c=0;
		   		  
		  
		 
		  
		  
		  while((line=read.readLine()) != null)
		  		{
		 			value=line.split(",");
		  
		 			Get_Data_FromFile  dat   = new Get_Data_FromFile(
		 					  
		 					 Integer.valueOf( value[0]),
		 					 Integer.valueOf( value[1]),
		 					 Integer.valueOf( value[2]),
		 					 Integer.valueOf( value[3]),
		 					 Integer.valueOf( value[4]),

		 					 Integer.valueOf( value[2]),
		 					 0, 
		 					 "null",
		 					 Integer.valueOf( value[5]),
		 					 Integer.valueOf( value[1])


		 					  );
		 			
		 			
		 		 	  data[c]=dat;
		 			  c++;
		  		}
		   
		  return data;
	 }
	
	
	
    public void print(Get_Data_FromFile [] input2) 
	    {
		  System.out.println("");
		  System.out.println("P   "+"A   "+"B   "+"W   "+"T  "+"C   "+"    S   Pirority\n");

			 for (int i = 0; i < input2.length; i++) 
			 {
				 System.out.print("P"+input2[i].id +"  "+input2[i].Arrive+"   "+input2[i].Burest+"  "+" "+input2[i].wait+"  "+" "+input2[i].total+"  "+input2[i].comple+"  "+"-> "+input2[i].stata+"  "+input2[i].pro);
				 System.out.println();
			}
	   }

	 

}
