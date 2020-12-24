package main.gtgbook.lifostack;

public class alsmain {

    public static void main(String[] args) {
        ArrayListStack<Integer> als = new ArrayListStack<>(3);
        als.push(0);
        als.push(1);
        als.push(2);
        als.push(3); //will resize
        System.out.println("Empty? = " + als.isEmpty());
        System.out.println("Size = " + als.size());
        System.out.println(als.toString());
        System.out.println(als.top());

        als.pop();
        System.out.println(als.top());

        /*clone and equals*/
        try {
            ArrayListStack<Integer> cloned = als.clone();
            System.out.println(cloned.toString());
            System.out.println("Clone Equals?: " + als.equals(cloned));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
