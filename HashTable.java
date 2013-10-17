import java.io.PrintStream;

public interface HashTable {
    public void put(int i);
    public void print(PrintStream ps);
    public int getNumCollisions();
}