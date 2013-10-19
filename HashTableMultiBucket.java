import java.io.PrintStream;

public class HashTableMultiBucket implements HashTable {
    private HashFunction hashFunction;
    private int tableSize;
    private int bucketsPerSlot;
    private int numSlots;
    private HashTableSlot table[];
    private CollisionResolver collisionResolver;
    private int numCollisions = 0;

    public HashTableMultiBucket(HashFunction _hashFunction, int _tableSize, int _bucketsPerSlot,
                                CollisionResolver _collisionResolver)
    {
        hashFunction = _hashFunction;
        tableSize = _tableSize;
        bucketsPerSlot = _bucketsPerSlot;
        numSlots = _tableSize / _bucketsPerSlot;
        table = new HashTableSlot[_tableSize];
        for (int i = 0; i < _tableSize; ++i) {
            table[i] = new HashTableSlot(_bucketsPerSlot);
        }
        collisionResolver = _collisionResolver;
        collisionResolver.setTable(this);
    }

    public int getTableSize() {
        return tableSize;
    }

    public int getNumSlots() {
        return numSlots;
    }

    public boolean slotFull(int i) {
        // A slot is full iff all of the buckets in that slot are full
        HashTableSlot s = table[i];
        for (int b = 0; b < bucketsPerSlot; ++b) {
            if (s.buckets[b] == -1) return false;
            // Every time we encounter a non-empty bucket, that's a collision
            numCollisions++;
        }
        return true;
    }

    public void put(int data) {
        // Get the hash value
        int hash = hashFunction.hash(data);
        // Limit its size
        int startSlot = hash % tableSize;

        // Resolve collisions
        int finalSlot = collisionResolver.findFreeSlot(startSlot);
        HashTableSlot s = table[finalSlot];

        // Insert the data into the first free bucket in this slot
        for (int b = 0; b < bucketsPerSlot; ++b) {
            if (s.buckets[b] == -1) {
                s.buckets[b] = data;
                return;
            }
        }
    }

    public int getNumCollisions() {
        return numCollisions;
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