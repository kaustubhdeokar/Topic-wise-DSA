package stack.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
//leetcode 30 sep - 1381. Design a Stack With Increment Operation

public class StackWithIncrementOperator {

    public static void main(String[] args) {

        CustomStack customStack = null;
        String[] operations;
        operations = new String[]{"CustomStack", "pop", "increment", "push", "increment", "increment", "increment", "pop", "increment"};
        int[][] vals;
        vals = new int[][]{{30}, {}, {3, 40}, {30}, {4, 63}, {2, 79}, {5, 57}, {}, {5, 32}};
        List<Integer> result = new ArrayList<>();
        result.add(null);
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "CustomStack" -> {
                    customStack = new CustomStack(vals[i][0]);
                    result.add(null);
                }
                case "push" -> {
                    customStack.push(vals[i][0]);
                    result.add(null);
                }
                case "pop" -> result.add(customStack.pop());

                case "increment" -> {
                    customStack.increment(vals[i][0], vals[i][1]);
                    result.add(null);
                }
            }
        }

        List<Integer> expected = Arrays.asList(null, null, -1, null, null, null, null, null, 229, null);
        System.out.println(result);
        System.out.println(result == expected);

    }

}

class CustomStack {

    private final int maxSize;
    Stack<Integer> stack;
    int[] incArr;

    public CustomStack(int maxSize) {
        stack = new Stack<>();
        this.maxSize = maxSize;
        incArr = new int[maxSize];
    }

    public void push(int x) {
        if (stack.size() < maxSize) {
            stack.push(x);
        }
    }

    public int pop() {
        if (!stack.isEmpty()) {
            int val = stack.pop();
            val += incArr[stack.size()];
            if (stack.size() > 0) {
                incArr[stack.size() - 1] += incArr[stack.size()];
            }
            incArr[stack.size()] = 0;
            return val;
        }
        return -1;
    }

    public void increment(int k, int val) {
        if (stack.size() > 0) {

            int arrPtr = Integer.min(k - 1, Integer.min(stack.size() - 1, maxSize - 1));
            incArr[arrPtr] += val;
        }

    }
}
