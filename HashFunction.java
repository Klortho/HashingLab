/**
 * This module defines all of the hashing functions.
 */

public interface HashFunction {
    public int hash(int data);

    public static HashFunction div_mod_120 = new HashFunction() {
        public int hash(int data) {
            return data % 120;
        }
    };
    public static HashFunction div_mod_127 = new HashFunction() {
        public int hash(int data) {
            return data % 127;
        }
    };
    public static HashFunction div_mod_41 = new HashFunction() {
        public int hash(int data) {
            return data % 41;
        }
    };
    public static HashFunction div_mod_custom = new HashFunction() {
        public int hash(int data) {
            return data;
        }
    };
}
