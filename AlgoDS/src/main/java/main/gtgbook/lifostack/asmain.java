package main.gtgbook.lifostack;

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
    }
}
