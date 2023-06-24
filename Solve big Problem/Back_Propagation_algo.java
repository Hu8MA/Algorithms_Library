package ML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class Back_Propagation_algo {
	 static int no_input=2 ;
		
	 static int no_out= 1 ; 
		
	 static int pattren = 0 ;
	  
	 static int input[][]=new int[4][no_input];
		
	 static int desierd_out[]=new int[4];
	  
	 static double out [] = new double [no_out];
	 
	 static double weight_I [][];
	 
     static double Hidden_layer [];
     
     static double weight_H [] ;

	
	public static void main(String[] args) throws Exception {
 
		readfile();
		
		// pritData(input , desierd_out);  that to can see that input and desierd_out
		 
		double local_error=0;
		
		int Global_error=0;
		
 		double actual_out=0;
 		
		int counter =0 ;
		 
		int no_Hidden= ( 2 * no_input ) + 1 ;
	 
		weight_I = new double [no_Hidden] [no_input];
		
		create_weight_I();
		 
	    Hidden_layer = new double  [no_Hidden];
	     
	    weight_H = new double  [no_Hidden];
	     
		create_weight_H();
 
		double Dalta_weight_H []= new double[no_Hidden];
		
		double Dalta_weight_I [][]= new double[no_Hidden][no_input];
		 
		
		System.out.println("\nthe weight of the input layer\n");
    	
		print_weight_I(weight_I);
    	 
	    System.out.println("\nthe weight of the hidden layer\n");

        print_weight_H(weight_H);
        
        
		do {
			 
			Global_error = 0 ;
			
			for (int i = 0; i < pattren ; i++) {
				
				
				  
				  for (int j = 0; j < Hidden_layer.length; j++) {
					  
					  	 print_Data_traing(input[i] , weight_I[j]);
					  
						 Hidden_layer[j] = Activation_Net( input[i] , weight_I[j] );
				 
				    } 
				  
				  
				  // to print value of hidden layer 
				  
				    print_Hidden(Hidden_layer);
				  
				   
				    //to calculate the out 
				    
				      for (int j = 0; j < no_out; j++) {
						
				    	
				    	actual_out = Activation_Net2(Hidden_layer, weight_H);
				    	
				    	out[j] = actual_out;
					}
				  
				     
				    // Calculate the locale error 
				    
				    for (int j = 0; j < out.length; j++) {
						
				    	local_error = desierd_out[i] - out[j] ;
					}
			     
 
			        System.out.println("the local error is = "+local_error);
			        
 			     
			     if ( local_error != 0)
			    	 
			     {
					    	 
					    	// calculate the Dalta_Weight between output & hidden layer
							 
			    	         // V_new=V_old + Dalta_V
			    	 
			    	         //Dalta_V= C * local error * input
			    	         //locale error = (d-o )* f(net2)
				 			 
			    	           //Dalta_V= C * d-o * f(net2) * input
			    	 
			    	 		// update the weight between the hidden layer & output layer
			    	 
					    	 
					    	 for (int j2 = 0; j2 < out.length; j2++) {
								
					    		 for (int j = 0; j < weight_H.length; j++) {
					    			 
					    			 Dalta_weight_H [j]  =   0.5 * local_error  * ( out[j2] - (out[j2] * out[j2] ) )  * Hidden_layer[j]  ;
					    			 
					    			 weight_H [j] = weight_H[j] + Dalta_weight_H [j] ;
					    			 
					    			 
					    		 }
							}
					    	   
					    	 // calculate the Δ W[j , j2 ]  hidden & input layer
						      
					    	 // W_new = W_old + Dalta_W
					    	  //Dalta_W = C * local error * input
					    	 
					    	 // local error = v * Dalata_V * f(net1)
					    	 
					    	 //Dalta_W = C * v * Dalata_V * f(net1) * input
					    	 
					    	 // up data the weight of input 
						
							
							for (int j = 0; j < Dalta_weight_I.length; j++) {
								
								for (int j2 = 0; j2 < Dalta_weight_I[j].length; j2++) {
									
									Dalta_weight_I[j][j2] = 0.5 * ( weight_H [j] * Dalta_weight_H[j] * (  Hidden_layer[j] - ( Hidden_layer[j] * Hidden_layer [j] )  )  ) * input[i][j2] ;
									
									weight_I[j][j2] = weight_I[j][j2] + Dalta_weight_I[j][j2];
								}
							}
					    	 
							 
			     		}
			       
			        Global_error += Math.abs(local_error);
				
 				}
					
			
					Global_error = (int)0.5 * Global_error;
				
					  counter++ ;
					  
					  
				  } while (Global_error != 0  );
					
						
		
				
				System.out.println("\nthe counter is  " + counter +"  the Globle error is " + Global_error);
					
	 
	}
 	public static  void readfile() throws Exception
		{
			// to read Data from external file (value_V2) => you can add that file in src  and the path is .csv
			
			 BufferedReader read =new BufferedReader(new FileReader("src\\value_V2.csv"));
			 
			 String line;
			 String value[]=null;
			 
			 
			 while ((line=read.readLine()) != null)
			 {
				 value=line.split(",");
				 
				 for(int i=0; i<value.length-1;i++)
				 {
					 input[pattren][i]=Integer.valueOf(value[i]);
				 }
				 
				 desierd_out[pattren]=Integer.valueOf(value[value.length-1]);
				 
				 pattren++;
			 }
			
      }

 	
		public static void pritData(int input[][], int desierd_out [])
		{
			// to to make sure that Data it fetch from file 
			
			System.out.println("\nX1\tX2\tD-out");
			
			for (int i = 0; i < input.length; i++) {
				
				for (int j = 0; j < input[i].length; j++) {
					
					System.out.print(input[i][j]+"\t");
				}
				
				System.out.println(desierd_out[i]);
				
				System.out.println();
			}
			 	
		}

 
		private static void create_weight_I( ) {
			
			// to create weight first trying 
			
			Random r = new Random();
			
			for (int i = 0; i < weight_I.length; i++) {
				
				for (int j = 0; j < weight_I[i].length; j++) {
					
					weight_I[i][j]=r.nextDouble();
				}
			}
			 
			
			//to make sure that have weight 
			
		 /*
		  	for (int i = 0; i < weight_I.length; i++) {
		 
				for (int j = 0; j < weight_I[i].length; j++) {
					
					System.out.println(weight_I[i]);
				}
			}
			
		  */
			 		
			}

 	
		
		private static void create_weight_H( ) {
			
			// to create weight first trying 
			
			Random r = new Random();
			
			for (int i = 0; i < weight_H.length; i++) {
				
 					
					weight_H[i]=r.nextDouble();
			
			}
			 //to make sure that have weight
			/*
			 
			for (int i = 0; i < weight_H.length; i++) {
				
				for (int j = 0; j < weight_H[i].length; j++) {
					
					System.out.println(weight_I[i]);
				}
			}
			
			*/
			
			 		
			}

   

		public static double Activation_Net(int input1 [] , double weight_I [])
		{
			
			double Net=0;
			
			for (int i = 0; i < input1.length; i++) {
				
				Net += input1[i] * weight_I[i];
			     
			}
			
			Net =( 1 / (1+ Math.exp(- Net)));
			
			return Net ;
		}

 
		
		public static double Activation_Net2(double Hidden [] , double weight_H [])
		{
			
			double Net2=0;
		
			for (int i = 0; i < weight_H.length; i++) {
				
				Net2 += Hidden[i] * weight_H[i] ;
			}
			
			//this is simple This is the simplest law (for the derivative of a function), 
			//but with the correct algorithm, there is a derivative imposed by the algorithm that is preferable to use

			Net2 =( 1 / (1+ Math.exp(- Net2)));
			
			return Net2 ;
			
		}

		 
		public static void print_Data_traing(int input [] , double weight [])
		{
			System.out.println();
			System.out.println("X1\tX2");
			
			for (int i = 0; i < input.length; i++) {
			 
				System.err.print(input[i]+"\t");
			}
			
			System.out.println("\n");
			
			System.out.println("W1\t\t\tW2");
			
		
			for (int i = 0; i < weight.length; i++) {
				System.out.print(weight[i]+"\t");
			}
			
			System.err.println("\n----------------------------------\n");
			
		 	
		}
 
		public static void print_Hidden(double hidden [] )
		{
			System.out.println();
			for (int i = 0; i < hidden.length; i++) {
				
			 	
					System.out.println(hidden[i]+"\t"+"H"+i);
			 			
			}
		}
 
		public static void print_weight_H(double weight_H [])
		
		{
			System.out.println();
			for (int i = 0; i < weight_H.length; i++) {
 					System.out.println(weight_H[i]+"\t");
			
			}
		}
		 
		private static void print_weight(double[][] weight_I) {

			for (int i = 0; i < weight_I.length; i++) {
				for (int j = 0; j < weight_I[i].length; j++) {
					System.out.print(weight_I[i][j]+"\t");

				}
				System.out.println();
			}
	}
		
}
