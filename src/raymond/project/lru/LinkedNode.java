package raymond.project.lru;

public class LinkedNode<K, V> {

    public K key;
    public V value;
    public LinkedNode pre;
    public LinkedNode next;

    public LinkedNode() {
        key = null;
        value = null;
        pre = next = null;
    }
}
