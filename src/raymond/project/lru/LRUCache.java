package raymond.project.lru;

import java.security.InvalidParameterException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * LRU
 * @param <K> key
 * @param <V> value
 */
public class LRUCache<K, V> {

    private int count;
    private int capacity;
    private ConcurrentHashMap<K, LinkedNode<K, V> > cache = new ConcurrentHashMap<>();
    private LinkedNode head;
    private LinkedNode tail;

    public LRUCache(int capacity) throws InvalidParameterException {
        this.count = 0;
        if(capacity < 1) {
            throw new InvalidParameterException("capacity must below 0");
        }
        this.capacity = capacity;
        /**
         * 为了后面移动节点方便。head和tail是哨兵节点
         */
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 增加LRU缓存，并将新增的节点移动到链表的最前方
     * 若为新增节点且到达LRU设置的缓存数量上限，则删除链表最后的节点
     * @param key
     * @param value
     */
    public void set(K key, V value) {
        LinkedNode<K, V> node = cache.get(key);

        if(node != null) {
            node.value = value;
            this.moveToHead(node);
        } else {
            LinkedNode<K, V> newNode = new LinkedNode<>();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);
            this.count++;

            if(count > capacity) {
                /**
                 * 移除链表中的最后一个节点
                 * 删除hashmap中最后一个节点的缓存
                 * count--
                 */
                --count;
                LinkedNode tailNode = this.popTail();
                this.cache.remove(tailNode.key);
            }

        }
    }

    /**
     * 查找LRU缓存，若存在的话将该节点移动到链表的最前方
     * @param key
     * @return null if key not find in cache
     */
    public V get(K key) {
        if(!cache.containsKey(key)) {
            return null;
        }

        LinkedNode<K, V> node = cache.get(key);
        this.moveToHead(node);
        return node.value;
    }

    /**
     * 新增节点都在链表的头
     * @param node
     */
    private void addNode(LinkedNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node) {
        LinkedNode preNode = node.pre;
        LinkedNode nextNode = node.next;

        preNode.next = nextNode;
        nextNode.pre = preNode;
    }

    private LinkedNode popTail() {
        LinkedNode res = this.tail.pre;
        this.removeNode(res);
        return res;
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    public static void printLRUCache(LRUCache lruCache) {
        LinkedNode head = lruCache.head.next;
        LinkedNode tail = lruCache.tail;
        while(head != null && head != tail) {
            System.out.print(head.key + ":" + head.value + "   ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lru = new LRUCache<>(3);
        lru.set(5, "haha");
        printLRUCache(lru);
        lru.set(10, "heihei");
        printLRUCache(lru);
        lru.set(15, "hehe");
        printLRUCache(lru);
        lru.set(20, "nono");
        printLRUCache(lru);
        lru.get(15);
        printLRUCache(lru);
        lru.get(10);
        printLRUCache(lru);
        lru.set(30, "yes");
        printLRUCache(lru);
    }
}