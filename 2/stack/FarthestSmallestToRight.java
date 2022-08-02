import java.util.Stack;

public class FarthestSmallestToRight {

    public int[] farthestSmallestToRight(int[] arr) {

        int[] suffixMinArr = findNearestSmallestToRight(arr);
        //this array will hold min element from index i to n-1

        int[] farthestToRight = new int[arr.length];
        calculateFarthestToRight(arr, suffixMinArr, farthestToRight);

        for (int i = 0; i < farthestToRight.length; i++) {
            if (farthestToRight[i] == Integer.MAX_VALUE)
                farthestToRight[i] = -1;
        }

        return farthestToRight;
    }

    private void calculateFarthestToRight(int[] arr, int[] suffixMin, int[] farthestToRight) {

        for (int i = 0; i < suffixMin.length; i++) {
            int smallest = Integer.MAX_VALUE;
            int start = i + 1;
            int end = suffixMin.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (suffixMin[mid] <= arr[i]) {
                    smallest = suffixMin[mid];
                    start = mid + 1;
                } else if (suffixMin[mid] > arr[i]) {
                    end = mid - 1;
                }
            }
            farthestToRight[i] = smallest;
        }
    }

    private int[] findNearestSmallestToRight(int[] arr) {
        int[] immediateSmallest = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                immediateSmallest[i] = arr[i];
            } else {
                immediateSmallest[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return immediateSmallest;
    }

}
