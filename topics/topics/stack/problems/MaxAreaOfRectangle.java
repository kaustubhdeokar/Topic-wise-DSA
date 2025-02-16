package stack.problems;

import java.util.Stack;

public class MaxAreaOfRectangle {


    public int largestRectangleArea(int[] heights) {

        int[] smallerToLeft = new int[heights.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() && stack.peek()[0] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                smallerToLeft[i] = -1;
            } else {
                smallerToLeft[i] = stack.peek()[1];
            }
            stack.push(new int[]{heights[i], i});
        }

        stack.clear();
        int maxArea = Integer.MIN_VALUE;

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                smallerToLeft[i] = heights.length - smallerToLeft[i] - 1;
            } else {
                smallerToLeft[i] = stack.peek()[1] - smallerToLeft[i] - 1;
            }
            maxArea = Integer.max(maxArea, smallerToLeft[i] * heights[i]);
            stack.push(new int[]{heights[i], i});
        }

        return maxArea;

    }

    public int maximalRectangle(char[][] matrix) {

        int maxAreaRec = Integer.MIN_VALUE;
        int[] prev = new int[matrix[0].length];
        int[] arr = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {


                if (matrix[i][j] == '0') {
                    arr[j] = 0;
                } else {
                    arr[j] = 1;
                    if (i > 0) {
                        arr[j] += prev[j];
                    }
                }
            }
            maxAreaRec = Integer.max(maxAreaRec, largestRectangleArea(arr));
            System.arraycopy(arr, 0, prev, 0, arr.length);

        }
        return maxAreaRec;
    }
}
