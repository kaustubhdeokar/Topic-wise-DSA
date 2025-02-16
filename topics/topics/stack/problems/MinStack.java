package stack.problems;

import java.util.Stack;

public class MinStack {


    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {

        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);

    }

    public void pop() {
        int top = stack.pop();
        if (top == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }


    public static void main(String[] args) {


        MinStack minStack = new MinStack();
        minStack.push(12);
        System.out.println(minStack.getMin());
        minStack.push(15);
        System.out.println(minStack.getMin());
        minStack.push(10);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}
