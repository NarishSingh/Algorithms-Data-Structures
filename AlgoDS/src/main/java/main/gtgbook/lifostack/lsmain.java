package main.gtgbook.lifostack;

import static main.gtgbook.lifostack.LinkedStack.matchDelimiters;
import static main.gtgbook.lifostack.LinkedStack.matchHTML;

public class lsmain {

    /**
     * Transfer all elements from first stack to the next such that top of S is bottom of T
     * R6.4
     *
     * @param s {LinkedStack} stack to transfer
     * @param t {LinkedStack} empty stack
     * @return {LinkedStack} t will all s elements transfered
     */
    public static <E> LinkedStack<E> transfer(LinkedStack<E> s, LinkedStack<E> t) {
        t = new LinkedStack<>(); //scrub or init t just to be safe

        while (!s.isEmpty()) {
            t.push(s.pop());
        }

        return t;
    }

    /**
     * Empty a populated linked stack recursively
     * R6.5
     *
     * @param l {LinkedStack} a linked stack
     * @return the same stack, now empty
     */
    public static <E> LinkedStack<E> emptyStack(LinkedStack<E> l) {
        if (l.isEmpty()) {
            return l;
        } else {
            l.pop();
            return emptyStack(l);
        }
    }

    /**
     * Append t before s, preserving original order of both, while leaving r in its original form
     * R6.20
     *
     * @param r {LinkedStack} maintains original form
     * @param s {LinkedStack} will hold appended stacks
     * @param t {LinkedStack} will be emptyed into s
     * @return {LinkedStack} s, with t appended before its original elements
     */
    public static <E> LinkedStack<E> appendStacks(LinkedStack<E> r,LinkedStack<E> s, LinkedStack<E> t){
        //store size of t for last append from r to s
        int tLen = t.size();

        //pop off t and add to r, this will put t in reverse order at top of r
        while (!t.isEmpty()){
            r.push(t.pop());
        }

        //pop off r, which will restore t's order and move to top of s
        for (int i = 0; i < tLen; i++) {
            s.push(r.pop());
        }

        //verify r is maintained
        System.out.println(r.toString());

        return s;
    }

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

        //transfer
        LinkedStack<Integer> s = new LinkedStack<>(); //123
        s.push(3);
        s.push(2);
        s.push(1);
        LinkedStack<Integer> t = new LinkedStack<>();

        System.out.println(transfer(s, t).toString()); //321

        //recursive emptying stack
        LinkedStack<Integer> emptyThis = new LinkedStack<>();
        emptyThis.push(1);
        emptyThis.push(2);
        emptyThis.push(3);
        emptyThis.push(4);
        emptyThis.push(5);
        emptyThis.push(6);
        emptyStack(emptyThis);
        System.out.println("\n" + emptyThis.isEmpty() + "\n");

        //append two stacks
        LinkedStack<Integer> a = new LinkedStack<>();
        a.push(3);
        a.push(2);
        a.push(1);
        LinkedStack<Integer> b = new LinkedStack<>();
        b.push(5);
        b.push(4);
        LinkedStack<Integer> c = new LinkedStack<>();
        c.push(9);
        c.push(8);
        c.push(7);
        c.push(6);

        System.out.println(appendStacks(a,b,c));
    }
}
