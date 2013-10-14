//test hash table - pure Tolstoy
import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class TestMyHashTable {
    static String testdatafile = "testdata.txt";
    static List<String> testdata = new ArrayList<String>();
    StringBuilder   results;
    BufferedReader  input;

    public static void main(String [] args) {
        //declare and initialize a hash table
        MyHashTable table = new MyHashTable(120);

        //Retrieve command line arguments.
        //if (args.length != 1) {
        //    System.out.println("Please Enter:  java fileName [input file pathname]");
        //        System.exit(1);
        //}

        StringBuffer sb = new StringBuffer();

        // Read in the test data
        try {
            BufferedReader input = new BufferedReader(new FileReader(testdatafile));
            String string;
            while ((string = input.readLine()) != null) {
                testdata.add(string);
            }
        }
        catch (Exception ioe) {
            System.err.println(ioe.toString());
            return;
        }
        System.out.println("Read in " + testdata.size() + " test data entries.");
    }
}
