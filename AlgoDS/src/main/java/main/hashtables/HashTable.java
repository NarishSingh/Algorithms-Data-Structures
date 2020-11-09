package main.hashtables;

import java.util.ArrayList;

public class HashTable<K, V> {
    ArrayList<HashNode<K, V>> hashTable;
    int numRows; //limit on buckets/rows for table

    public HashTable(int rowNum) {
        hashTable = new ArrayList<>();
        numRows = rowNum;

        for (int i = 0; i < numRows; i++) {
            hashTable.add(null);
        }
    }

    /**
     * hash function to find index for a key
     *
     * @param key {generic}
     * @return {int} index of a row/bucket
     */
    private int getRowIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numRows;

        return index;
    }

    /**
     * Remove from hash table
     *
     * @param key {generic}
     * @return {generic} removed value
     */
    public V remove(K key) {
        //get index and grab the node
        int bucketIndex = getRowIndex(key);
        HashNode<K, V> current = hashTable.get(bucketIndex);
        HashNode<K, V> previous = null; //track the previous

        //search to see if it contains the key we want to remove
        while (current != null) { //while we haven't reached the end
            //if we found it
            if (current.key.equals(key)) {
                if (previous != null) {
                    //stitch together the neighbors
                    previous.next = current.next;
                    current.next.prev = previous;
                    //cut connections which the one to be deleted
                    current.prev = null;
                    current.next = null;
                } else {
                    hashTable.set(bucketIndex, current.next); //if its first in list, just reset the head to be next one
                }
                return current.value;
            }

            //if we haven't found it keep looping
            previous = current;
            current = current.next;
        }

        return null;
    }

    /**
     * Search table and retrieve value at key
     *
     * @param key {generic} key
     * @return {generic} value
     */
    public V get(K key) {
        // Find head of chain for given key
        int bucketIndex = getRowIndex(key);
        HashNode<K, V> current = hashTable.get(bucketIndex);

        // Search key in chain
        while (current != null) {
            if (current.key.equals(key))
                return current.value;
            current = current.next;
        }

        return null; // If key not found
    }

    /**
     * Add to hashtable, uses chaining to search the hashtable
     *
     * @param key   {generic} key
     * @param value {generic} value
     */
    public void add(K key, V value) {
        int bucketIndex = getRowIndex(key); //find head of HT row
        HashNode<K, V> current = hashTable.get(bucketIndex); //retrieve that bucket/row
        HashNode<K, V> newNode = new HashNode<>(key, value); //create a node w new data to be added

        //if HT is empty, just put it in
        if (current == null) {
            hashTable.set(bucketIndex, newNode);
            return;
        }

        HashNode<K, V> previous = null;
        while (current != null) {
            previous = current;
            current = current.next;
        }

        previous.next = newNode;
        newNode.prev = previous;
    }
}
