/**
  Objects of this class implement one slot in a hash table.  It might have multiple
  buckets, and might also have a doubly-linked list (in the case of in-table chained
  collision resolving).
*/
public class HashTableSlot {
    int buckets[];        // value of -1 means no data
    public int previous;  // link to the previous slot
    public int next;      // link to the next slot

    public HashTableSlot(int bucketSize, int _previous, int _next) {
        buckets = new int[bucketSize];
        for (int i = 0; i < bucketSize; ++i) {
            buckets[i] = -1;
        }
        previous = _previous;
        next = _next;
    }
}