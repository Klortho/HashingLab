public class CollisionResolverQuadratic implements CollisionResolver {

    private HashTable table;
    private int numSlots;
    private int numCollisions = 0;
    
    public CollisionResolverQuadratic() {
    }
    
    public void setTable(HashTable _table) {
        table = _table;
        numSlots = table.getNumSlots();
    
    }
    
    public int findFreeSlot(int startSlot) {
        int slot = startSlot;
        int i = 0;
        while (table.slotFull(slot)) {
            numCollisions++;
            i++;
            slot = (slot + (1/2*i + 1/2*i^2)) % numSlots;
            
        }
        return slot;
    
    }



}