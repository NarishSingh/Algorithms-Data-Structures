/*
155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:
MinStack() initializes the stack object.
void push(val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.


Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2


Constraints:
-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin
 */
package main.leetcode;

public class minStack {
    public static class MinStack {
        private int[] data;
        private int t; //i of top

        public MinStack() {
            this.data = new int[1000]; //max capacity of arr
            this.t = -1;
        }

        /**
         * Add onto stack
         *
         * @param val int to be pushed to top/end
         */
        public void push(int val) {
            data[++t] = val;
        }

        /**
         * Remove from bottom/end of stack
         */
        public void pop() {
            if (t == -1) return; //if empty, do nothing

            data[t--] = 0;
        }

        /**
         * Peek at top/end of stack
         *
         * @return int at top
         */
        public int top() {
            return data[t];
        }

        /**
         * Get the minimum element in stack
         *
         * @return int for min value present
         */
        public int getMin() {
            int min = Integer.MAX_VALUE;
            //stack length = t+1
            for (int i = 0; i < t + 1; i++) {
                if (data[i] < min) min = data[i];
            }

            return min;
        }
    }

    public static void main(String[] args) {
        // FIXME: 6/28/2021 fails past 1000 due to arr constraint...
        MinStack test1 = new MinStack();
        test1.push(-2);
        test1.push(0);
        test1.push(-3);
        System.out.println(test1.getMin());
        test1.pop();
        System.out.println(test1.top());
        System.out.println(test1.getMin());
    }
}
