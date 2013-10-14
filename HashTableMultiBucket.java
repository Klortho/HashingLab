import java.io.PrintStream;

public class HashTableMultiBucket implements HashTable {
    public int tableSize;
    public int bucketsPerSlot;
    public int numSlots;
    public HashTableSlot table[];

    public HashTableMultiBucket(int hashFunction, int _tableSize, int _bucketsPerSlot, int collisionResolver) {
        tableSize = _tableSize;
        bucketsPerSlot = _bucketsPerSlot;
        numSlots = _tableSize / _bucketsPerSlot;
        table = new HashTableSlot[_tableSize];
        for (int i = 0; i < _tableSize; ++i) {
            table[i] = new HashTableSlot(_bucketsPerSlot);
        }
    }



    /**
      In the cases where we have multiple buckets / slot, we print the table
      with one slot per row.
     */

    public void print(PrintStream ps) {
        for (int i = 0; i < numSlots; i++) {
            HashTableSlot hts = table[i];
            for (int j = 0; j < bucketsPerSlot; ++j) {
                ps.format("%6d", hts.buckets[j]);
            }
            ps.print("\n");
        }
    }


}