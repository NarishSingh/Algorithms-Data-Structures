package main.hashtables;

public class example {
    public static void main(String[] args) {
        HashTable<String, Integer> ht = new HashTable<>(10);
        ht.add("this", 1);
        ht.add("coder", 2);
        ht.add("this", 4);
        ht.add("hi", 5);

//        for (int i = 0; i < ht.hashTable.size(); i++) {
//            System.out.println(ht.hashTable.get(i));
//        }

        System.out.println(ht.hashTable.get(0).value);
        System.out.println(ht.hashTable.get(0).next.value);
        System.out.println(ht.remove("this"));
        System.out.println(ht.hashTable.get(0).value);
        // System.out.println(ht.remove("this"));
        // System.out.println(ht.hashTable.get(0).value);
        // System.out.println(ht.remove("this"));

    }
}
