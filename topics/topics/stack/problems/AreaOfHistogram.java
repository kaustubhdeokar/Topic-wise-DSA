package stack.problems;

import java.util.Stack;

public class AreaOfHistogram {

    public static void main(String[] args) {

        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        //           0  1  2  3  4  5  6
        AreaOfHistogram a = new AreaOfHistogram();
        System.out.println("Area of histogram: " + a.findMaxAreaOfHistogram(arr));
    }

    int findMaxAreaOfHistogram(int[] heights) {

        Stack<int[]> leftStack = new Stack<>();
        int[] leftResult = populateLeftLimitingElem(heights, leftStack);
        for (int i : leftResult) {
            System.out.print(i + " ");
        }
        System.out.println();
        Stack<int[]> rightStack = new Stack<>();
        int[] rightResult = populateRightLimitingElem(heights, rightStack);
        for (int i : rightResult) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < leftResult.length; i++) {
            System.out.print(heights[i] * (rightResult[i] - leftResult[i] - 1) + " ");
        }

        return -1;
    }

    public AreaOfHistogram() {
    }

    private int[] populateLeftLimitingElem(int[] arr, Stack<int[]> stack) {

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                stack.pop();
            }
            //got stuck here.
            //so the point is to store the limiting factor of the current element.
            //if it exceeds the boundary, store the boundary +1 (or boundary -1) index.

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek()[1];
            }
            stack.push(new int[]{arr[i], i});
        }


        return result;
    }

    private int[] populateRightLimitingElem(int[] arr, Stack<int[]> stack) {

        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = arr.length;
            } else {
                result[i] = stack.peek()[1];
            }
            stack.push(new int[]{arr[i], i});
        }


        return result;
    }


}
