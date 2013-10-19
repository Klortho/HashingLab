import java.io.PrintStream;

public interface HashTable {
    public int getTableSize();
    public int getNumSlots();

    public void put(int i);
    public boolean slotFull(int i);
    public void print(PrintStream ps);
    public int getNumCollisions();
}
