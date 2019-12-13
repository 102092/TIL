package hash;

/**
 * HashTable
 */
public class ChainHash<K, V> {
    private int size;
    private Node<K, V>[] table;

    public ChainHash(int capacity) {
        try {
            table = new Node[capacity];
            this.size = capacity;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    public V search(K key) {
        int hash = hashValue(key);
        Node<K, V> p = table[hash];

        while (p != null) {
            if (p.getKey().equals(key))
                return p.getData();
            p = p.next;
        }
        return null;
    }

    /**
     * Node<K,V>
     */
    public class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> next;

        Node(K key, V data, Node<K, V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        /**
         * @return the key
         */
        public K getKey() {
            return key;
        }

        /**
         * @return the data
         */
        public V getData() {
            return data;
        }

        public int hashCode() {
            return key.hashCode();
        }
    }

    public static void main(String[] args) {

    }
}