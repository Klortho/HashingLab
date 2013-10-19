public class CollisionResolverLinear implements CollisionResolver {
    private HashTable table;
    private int numSlots;
    private int numCollisions = 0;

    public CollisionResolverLinear() {
    }

    public void setTable(HashTable _table) {
        table = _table;
        numSlots = table.getNumSlots();
    }

    public int findFreeSlot(int startSlot) {
        int slot = startSlot;
        while (table.slotFull(slot)) {
            numCollisions++;
            slot = (slot + 1) % numSlots;
            if (slot == startSlot) return -1;  // table is full.
        }
        return slot;
    }
}
