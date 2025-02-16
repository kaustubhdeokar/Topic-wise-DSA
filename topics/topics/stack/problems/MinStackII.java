package stack.problems;

import java.util.Stack;

public class MinStackII {

    Stack<int[]> stack;
    int min = Integer.MAX_VALUE;

    public MinStackII() {
        stack = new Stack<int[]>();
    }

    public void push(int val) {
        int[] top = stack.isEmpty() ? new int[]{val, val} : stack.peek();
        int min = top[1];
        if (val < min) {
            min = val;
        }
        stack.push(new int[]{val, min});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek()[0];
    }

    public int getMin() {
        if(stack.isEmpty()) return -1;
        return stack.peek()[1];
    }


    public static void main(String[] args) {


        MinStackII minStack = new MinStackII();
        minStack.push(-10);
        System.out.println(minStack.getMin());
        minStack.push(14);
        System.out.println(minStack.getMin());
        minStack.push(-20);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(10);
        System.out.println(minStack.getMin());
        minStack.push(-7);
        System.out.println(minStack.getMin());
    }
}
