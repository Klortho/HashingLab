import java.io.PrintStream;

public class HashTableOneBucket implements HashTable {
    public HashFunction hashFunction;
    public int tableSize;
    public int table[];
    public int numCollisions = 0;

    public HashTableOneBucket(HashFunction _hashFunction, int _tableSize, int collisionResolver)
    {
        hashFunction = _hashFunction;
        tableSize = _tableSize;
        table = new int[_tableSize];
        for (int i = 0; i < _tableSize; ++i) {
            table[i] = -1;
        }
    }

    public void put(int data) {
        // Get the hash value
        int hash = hashFunction.hash(data);
        // Limit its size
        int slot = hash % tableSize;
        // Resolve collisions
        while (table[slot] != -1) {
            numCollisions++;
            slot++;
        }
        table[slot] = data;
    }

    public int getNumCollisions() {
        return numCollisions;
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