package stack.MinStack;

import java.util.Stack;

public class MinStack extends Stack<Integer> {

    private int min;

    MinStack() {
        min = Integer.MAX_VALUE;
    }

    public int getMin() {
        return min;
    }

    @Override
    public Integer push(Integer item) {
        if (item <= min) {
            this.add(min);
            min = item;
        }
        this.add(item);
        return item;
    }

    @Override
    public synchronized Integer pop() {
        Integer top = super.pop();
        if (top.equals(min)) {
            min = super.pop();
        }
        return top;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 1, 8, 1};
        MinStack minStack = new MinStack();
        for (int i : arr) {
            minStack.push(i);
        }
        minStack.iterator().forEachRemaining(System.out::println);
    }
}
