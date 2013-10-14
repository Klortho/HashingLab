import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;


public class TestHashTables {
    static String testdatafile = "testdata.txt";
    static List<String> testdata = new ArrayList<String>();

    public static void main(String [] args) {
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


        run_tests("Division module 120, 120 slots, 1 bucket / slot, linear probing",
                  new HashTableOneBucket(0, 120, 0));
        run_tests("Division module 120, 40 slots, 3 bucket / slot, linear probing",
                  new HashTableMultiBucket(0, 120, 3, 0));

        //declare and initialize a hash table
        //MyHashTable table = new MyHashTable(120);
    }

    public static void run_tests(String title, HashTable table) {
        System.out.println("======================================================");
        System.out.println(title);
        table.print(System.out);
    }
}
