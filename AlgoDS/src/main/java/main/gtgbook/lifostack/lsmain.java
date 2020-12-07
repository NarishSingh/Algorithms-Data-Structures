package main.gtgbook.lifostack;

import static main.gtgbook.lifostack.LinkedStack.matchDelimiters;
import static main.gtgbook.lifostack.LinkedStack.matchHTML;

public class lsmain {

    public static void main(String[] args) {
        LinkedStack<Double> l = new LinkedStack<>();

        l.push(6.5);
        l.push(9.5);

        System.out.println(l.size());
        System.out.println(l.isEmpty());
        System.out.println(l.top());

        l.pop();
        System.out.println(l.top());

        //check matched delimiters
        String m = "{yeaaa}";
        String m2 = "{}}{noooooooooo";

        System.out.println("\n" + matchDelimiters(m));
        System.out.println(matchDelimiters(m2));

        //match html code
        String html1 = "<a>A link</a>";
        System.out.println("\n" + matchHTML(html1));
    }
}
