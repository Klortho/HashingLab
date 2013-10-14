import java.io.PrintStream;

public class HashTableOneBucket implements HashTable {
    public int tableSize;
    public int table[];

    public HashTableOneBucket(int hashFunction, int _tableSize, int collisionResolver) {
        tableSize = _tableSize;
        table = new int[_tableSize];
        for (int i = 0; i < _tableSize; ++i) {
            table[i] = -1;
        }
    }



    public void insertLinearProbe(int key, int tableSize) {
        int address = hashFunction(key, tableSize);
        for (int i = 0; i < table.length; i++) {
            address = key + i;
            if (table[address] == -1) {
                //table[address] = key;
            }
            //keep looking
        }
    }

    public static int hashFunction(int key, int tableSize) {
        int k = key;
        int m = tableSize;
        int address = k % m;
        return address;
    }

    /**
      In the cases where we have one bucket / slot, we are supposed to print the table
      five elements across.
     */
    public void print(PrintStream ps) {
        for (int i = 0; i < tableSize; i++) {
            ps.format("%6d", table[i]);
            if (i % 5 == 4) ps.print("\n");
        }
    }

}