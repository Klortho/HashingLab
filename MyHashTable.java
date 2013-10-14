public class MyHashTable {
    Integer [] table;
    int size;

    //a no arg constructor
    public MyHashTable() {
    }

    public MyHashTable(int size) {
        table = new Integer [size];
    }

    public void insertLinearProbe(int key, int tableSize) {
        int address = hashFunction(key, tableSize);
        for (int i = 0; i < table.length; i++) {
            address = key + i;
            if (table[address] == null) {
                table[address] = key;
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