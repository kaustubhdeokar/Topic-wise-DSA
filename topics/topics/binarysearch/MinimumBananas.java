package binarysearch;


//edge cases - 1 low should be 0, bananas can be consumed at a slower speed than the lowest element in the array.
//ceil calculation - a/b + (a%b>0)?1:0


public class MinimumBananas {

    public static void main(String[] args) {

        int[] arr = new int[]{30, 11, 23, 4, 20};
        int k = 5;
        MinimumBananas mb = new MinimumBananas();
        mb.minEatingSpeed(arr, k);
    }

    public int minEatingSpeed(int[] arr, int k) {

        int n = arr.length;
        int low = 0;
        int high = Integer.MIN_VALUE;
        for (int i : arr) {
            high = Integer.max(high, i);
        }

        int minBananas = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == 0) break;
            int hoursTaken = 0;
            for (int i = 0; i < n; i++) {
                hoursTaken += arr[i] / mid;
                if (arr[i] % mid > 0) hoursTaken += 1;
            }
            if (hoursTaken <= k && mid < minBananas) {
                minBananas = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return minBananas;
    }


}
