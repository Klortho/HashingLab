import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class TestMyHashTable {

    //declare class level variables here
    StringBuilder   results;
    BufferedReader  input;
    
    
    
    public static void main(String [] args) {
    
    //declare and initialize a hash table
    MyHashTable table = new MyHashTable(120);
    
    
    //Retrieve command line arguments.
    if (args.length != 1) {
        System.out.println("Please Enter:  java fileName [input file pathname]");
            System.exit(1);
    }
    
    StringBuffer sb = new StringBuffer();
    
     //Open the file that will be used for input.
        try {
             BufferedReader input = new BufferedReader(new FileReader(args[0]));
             
              //read the input line by line and store in string variable
              while ((string = input.readLine()) != null) {
                  
        	    sb.append(string + "\n");
        		data = sb.toString();  
        		
        		//store each string in an array for later formatting
        		stringArray = data.split("\n");
        		 
               }
             
               
        } catch (Exception ioe) {
          System.err.println(ioe.toString());
            return;
        }
    
    
    
    
    }

}