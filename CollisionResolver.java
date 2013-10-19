/**
 * This module defines an interface and factory for a hash table collision resolver.
 */

public interface CollisionResolver {
    public void setTable(HashTable _table);
    public int findFreeSlot(int startSlot);
}

