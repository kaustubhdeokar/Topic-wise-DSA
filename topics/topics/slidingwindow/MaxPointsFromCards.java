package slidingwindow;

public class MaxPointsFromCards {

    public static void main(String[] args) {
        MaxPointsFromCards mpc = new MaxPointsFromCards();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 1};
        int k = 3;

        int r = mpc.maximumPointsFromCards(arr, k);
        System.out.println(r);
    }

    public int maximumPointsFromCards(int[] arr, int k) {

        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += arr[i];
        }

        int arrLen = arr.length;
        int maxSum = currSum;
        int end = k;
        int start = 0;

        for (int i = 0; i < k; i++) {
            if (end == 0) {
                end = arrLen - 1;
            } else {
                end -= 1;
            }

            if (start == 0) {
                start = arrLen - 1;
            } else {
                start -= 1;
            }

            currSum -= arr[end];
            currSum += arr[start];
            maxSum = Integer.max(maxSum, currSum);
        }

        return maxSum;

    }

}
