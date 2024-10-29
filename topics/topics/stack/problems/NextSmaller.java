package stack.problems;

import java.util.Stack;

public class NextSmaller {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 4, 2, 7, 6, 3, 0};
        NextSmaller nextSmaller = new NextSmaller();
        nextSmaller.toLeftByBruteForce(arr);
        nextSmaller.toLeftByStack(arr);
        nextSmaller.toRightByStack(arr);
    }

    private void toRightByStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int arrLen = arr.length;
        int[] res = new int[arrLen];
        for (int i = arrLen - 1; i >= 0; i--)
        {
            int curr = arr[i];
            while (!stack.isEmpty() && stack.peek() >= curr) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(curr);
        }

        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void toLeftByStack(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int arrLen = arr.length;
        int[] res = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            int curr = arr[i];
            while (!stack.isEmpty() && stack.peek() >= curr) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(curr);
        }

        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    public void toLeftByBruteForce(int[] arr) {
        int arrLen = arr.length;
        int[] res = new int[arrLen];

        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    res[i] = arr[j];
                    found = true;
                    break;
                }
            }
            if (!found) {
                res[i] = -1;
            }
        }

        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

}
