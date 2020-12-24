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

        System.out.println("\n");

        //FIXME this is not popping all for some reason
        for (int i = 0; i < als.size(); i++) {
            System.out.println(als.top());
            als.pop();
        }
    }
}
