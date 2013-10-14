public class HashTableImpl implements HashTable {
    public HashTableSlot table[];

    public HashTableImpl(int hashFunction, int tableSize, int bucketSize, int collisionResolver) {
        table = new HashTableSlot[tableSize];
        for (int i = 0; i < tableSize; ++i) {
            int next = i == tableSize - 1 ? -1 : i + 1;
            table[i] = new HashTableSlot(bucketSize, i - 1, next);
        }
    }





    public void insertLinearProbe(int key, int tableSize) {
        int address = hashFunction(key, tableSize);
        for (int i = 0; i < table.length; i++) {
            address = key + i;
            if (table[address] == null) {
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

    public String printArrayTable(Integer [] m) {
        StringBuilder results = new StringBuilder();

        for (int i = 0; i < m.length; i++) {
            if (i % 6 == 0)
                results.append(i + "\n");
            else
                results.append(i);
        }
        return results.toString();
    }

    public String print40Table(Integer [] m) {
        StringBuilder results2 = new StringBuilder();

        for (int i = 0; i < m.length; i++) {
            if (i % 4 == 0)
                results2.append(i + "\n");
            else
                results2.append(i);
        }

        return results2.toString();
    }
}