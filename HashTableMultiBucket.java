public class HashTableMultiBucket implements HashTable {
    public HashTableSlot table[];

    public HashTableMultiBucket(int hashFunction, int tableSize, int bucketsPerSlot, int collisionResolver) {
        int numSlots = tableSize / bucketsPerSlot;
        table = new HashTableSlot[tableSize];
        for (int i = 0; i < tableSize; ++i) {
            int next = i == tableSize - 1 ? -1 : i + 1;
            table[i] = new HashTableSlot(bucketsPerSlot, i - 1, next);
        }
    }




    public String print() {
        StringBuilder results = new StringBuilder();

      /*
        for (int i = 0; i < m.length; i++) {
            if (i % 4 == 0)
                results2.append(i + "\n");
            else
                results2.append(i);
        }
      */
        return results.toString();
    }


}