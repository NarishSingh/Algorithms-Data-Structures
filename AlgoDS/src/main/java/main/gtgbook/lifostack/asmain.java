package main.gtgbook.lifostack;

import java.util.Arrays;

import static main.gtgbook.lifostack.ArrayStack.reverse;


public class asmain {

    public static void main(String[] args) {
        Stack<Integer> s = new ArrayStack<>(10); //without param, would construct w max len 1000
        s.push(10);
        s.push(3);

        System.out.println(s.top());
        System.out.println("Size = " + s.size());

        s.pop();

        System.out.println(s.top());

        s.pop();
        System.out.println(s.isEmpty());

        //reverse
        String[] arr = {"Hello", "Good bye"};
        System.out.println(Arrays.toString(arr));

        reverse(arr);
        System.out.println(Arrays.toString(arr));

        //clone and equals
        ArrayStack<Integer> a = new ArrayStack<>(3);
        a.push(1);
        a.push(2);
        a.push(3);
        try {
            System.out.println("\nOriginal: " + a.toString());

            ArrayStack<Integer> cloned = a.clone(); //FIXME is throwing CloneNotSupportedException
            System.out.println("Cloned: " + cloned.toString());
            System.out.println(a.equals(cloned));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
