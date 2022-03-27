package stack;

import java.util.Stack;

public class NextSmallestElement {

    public void nextSmallestElementToRight(int[] arr) {

        int arrLen = arr.length;
        int[] result = new int[arrLen];
        Stack<Integer> stack = new Stack<>();

        for (int i = arrLen - 1; i > -1; i--) {
            nextGreater(result, stack, i, arr[i]);

        }

        for (int i : result) {
            System.out.print(i + " ");
        }

    }

    public void nextSmallestElementToLeft(int[] arr) {

        int arrLen = arr.length;
        int[] result = new int[arrLen];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arrLen; i++) {
            nextGreater(result, stack, i, arr[i]);
        }

        for (int i : result) {
            System.out.print(i + " ");
        }

    }

    private void nextGreater(int[] result, Stack<Integer> stack, int i, int i1) {
        while (!stack.isEmpty() && stack.peek() > i1) {
            stack.pop();
        }
        if (!stack.empty()) {
            result[i] = stack.peek();
        } else {
            result[i] = -1;
        }
        stack.push(i1);
    }

    public static void main(String[] args) {

        NextSmallestElement nse = new NextSmallestElement();
        nse.nextSmallestElementToRight(new int[]{5,1,4,3,2});
        System.out.println();
        nse.nextSmallestElementToLeft(new int[]{5,1,4,3,2});
    }
}
