package stack.problems;

import java.util.Stack;

public class NextGreaterToRight {

    public static void main(String[] args) {

        NextGreaterToRight nextGreaterToRight = new NextGreaterToRight();
        int[] arr = new int[]{1, 3, 2, 4};
        nextGreaterToRight.nextGreaterToRight(arr);
        nextGreaterToRight.nextGreaterToLeft(arr);
    }

    public int[] nextGreaterToRight(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
        return result;
    }

    public int[] nextGreaterToLeft(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = 0 ; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
        return result;
    }


}
