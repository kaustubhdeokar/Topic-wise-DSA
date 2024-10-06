package dp.knapsack;

public class MinimumNumberOfElementsToRemove {

    public static void main(String[] args) {

        int[] arr = {3, 1, 4, 2, 4, 2};
        int p = 6;

        MinimumNumberOfElementsToRemove min = new MinimumNumberOfElementsToRemove();
        System.out.println(min.recursive(arr, arr.length, 0, p));

    }

    public long recursive(int[] arr, int arrPtr, int currSum, int p) {
        if (arrPtr == 0)
            return Integer.MIN_VALUE;
        if (currSum >= p && currSum % p == 0) {
            return 0;
        }

        if (arr[arrPtr - 1] + currSum <= p) {
            long a = 1 + recursive(arr, arrPtr - 1, currSum + arr[arrPtr - 1], p);
            long b = recursive(arr, arrPtr - 1, 0, p);
            return Long.max(a, b);
        } else if ((arr[arrPtr - 1] + currSum) > p) {
            return recursive(arr, arrPtr - 1, 0, p);
        }
        return Integer.MIN_VALUE;
    }


}
