package main.hashtables;

/**
 * Will function like linked lists basically
 * @param <K> generic type for key
 * @param <V> generic type for value
 */
public class HashNode<K, V> {
    K key;
    V value;
    //HN's so we can search through
    HashNode<K, V> next;
    HashNode<K, V> prev;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
