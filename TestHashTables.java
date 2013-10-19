import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;


public class TestHashTables {
    static String testdatafile = "testdata.txt";
    static List<Integer> testdata = new ArrayList<Integer>();

    public static void main(String [] args) {
        StringBuffer sb = new StringBuffer();

        // Read in the test data
        try {
            BufferedReader input = new BufferedReader(new FileReader(testdatafile));
            String string;
            while ((string = input.readLine()) != null) {
                testdata.add(Integer.parseInt(string));
            }
        }
        catch (Exception ioe) {
            System.err.println(ioe.toString());
            return;
        }
        System.out.println("Number of test data items = " + testdata.size() + "\n");


        run_tests("Division module 120, 120 slots, 1 bucket / slot, linear probing",
                  new HashTableOneBucket(HashFunction.div_mod_120, 120, 0));
        //run_tests("Division module 120, 120 slots, 1 bucket / slot, quadratic probing",
        //          new HashTableOneBucket(HashFunction.div_mod_120, 120, 1));
        //run_tests("Division module 120, 120 slots, 1 bucket / slot, in-table chaining",
        //          new HashTableOneBucket(HashFunction.div_mod_120, 120, 2));

        run_tests("Division module 127, 120 slots, 1 bucket / slot, linear probing",
                  new HashTableOneBucket(HashFunction.div_mod_127, 120, 0));
        //run_tests("Division module 127, 120 slots, 1 bucket / slot, quadratic probing",
        //          new HashTableOneBucket(HashFunction.div_mod_127, 120, 1));
        //run_tests("Division module 127, 120 slots, 1 bucket / slot, in-table chaining",
        //          new HashTableOneBucket(HashFunction.div_mod_127, 120, 2));

        run_tests("Division module 41, 40 slots, 3 buckets / slot, linear probing",
                  new HashTableMultiBucket(HashFunction.div_mod_41, 40, 3, 0));
        //run_tests("Division module 41, 40 slots, 3 buckets / slot, quadratic probing",
        //          new HashTableMultiBucket(HashFunction.div_mod_41, 40, 3, 1));
        //run_tests("Division module 41, 40 slots, 3 buckets / slot, in-table chaining",
        //          new HashTableMultiBucket(HashFunction.div_mod_41, 40, 3, 2));

        run_tests("Custom hash function, 120 slots, 1 bucket / slot, linear probing",
                  new HashTableOneBucket(HashFunction.custom, 120, 0));
        //run_tests("Custom hash function, 120 slots, 1 bucket / slot, quadratic probing",
        //          new HashTableOneBucket(HashFunction.custom, 120, 1));
        //run_tests("Custom hash function, 120 slots, 1 bucket / slot, in-table chaining",
        //          new HashTableOneBucket(HashFunction.custom, 120, 2));
    }

    public static void run_tests(String title, HashTable table) {
        System.out.println("======================================================");
        System.out.println(title);

        for (int i = 0; i < testdata.size(); ++i) {
            table.put(testdata.get(i));
        }

        table.print(System.out);
        System.out.println("\nNumber of collisions:  " + table.getNumCollisions());
    }
}
