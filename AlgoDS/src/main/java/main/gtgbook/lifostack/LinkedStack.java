/*
Stack implementation with singly linked list
gets around issue of space with dynamic allocation
front of list will be made the top of the stack to keep it in O(n)

note: this is an example of adapter design pattern ->
 */
package main.gtgbook.lifostack;

import main.gtgbook.singlylinkedlist.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public LinkedStack() {
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public String toString() {
        return "LinkedStack{" +
                "list=" + list +
                '}';
    }

    /**
     * Check for matching delimiters ({[ in a string
     *
     * @param s {String} any string
     * @return {boolean} true if all delimiters were matched, false otherwise
     */
    public static boolean matchDelimiters(String s) {
        if (s.isBlank()) {
            return true;
        }

        final String opening = "({[";
        final String closing = ")}]";

        //check chars in string if they match w an opening or closing paren
        Stack<Character> buffer = new LinkedStack<>();
        for (char c : s.toCharArray()) {
            //if a paren char, push to buffer if opening, pop from buffer if closing and matching
            if (opening.indexOf(c) != -1) {
                buffer.push(c);
            } else if (closing.indexOf(c) != -1) {
                //all closing must be matched to an opening
                if (buffer.isEmpty()) {
                    return false; //if nothing to match, fails
                }

                if (closing.indexOf(c) != opening.indexOf(buffer.pop())) {
                    return false; //if mismatched to the closest push to buffer, fails
                }
            }
        }

        //finally, buffer should be empty for pass
        return buffer.isEmpty();
    }

    /**
     * Verify matching HTML tags
     *
     * @param html {String} raw html code
     * @return {boolean} true if all tags match, false otherwise
     */
    public static boolean matchHTML(String html) {
        Stack<String> buffer = new LinkedStack<>();

        //loop through the <>'s
        int j = html.indexOf('<');
        while (j != -1) {
            int k = html.indexOf('>', j + 1);
            if (k == -1) {
                return false; //if no closing brace, fails
            }

            //if tag isn't </standaloneTagName>, push to buffer then pop when matched
            String tag = html.substring(j + 1, k);
            if (!tag.startsWith("/")) {
                buffer.push(tag);
            } else {
                if (buffer.isEmpty()) {
                    return false; //if nothing to match, fails
                }

                if (!tag.substring(1).equals(buffer.pop())) {
                    return false; //if mismatched, fails
                }

            }

            j = html.indexOf('<', k + 1); //jump to next <
        }

        //buffer must be empty for pass
        return buffer.isEmpty();
    }
}
