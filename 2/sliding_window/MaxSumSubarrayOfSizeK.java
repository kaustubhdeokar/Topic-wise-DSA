import java.util.*;

public class MaxSumSubarrayOfSizeK {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        System.out.println("max subarray:" + maximumSumSubarray(2, list, list.size()));

    }

    static long maximumSumSubarray(int K, ArrayList<Integer> arr, int N) {

        //start=0  //end=0
        long maxSum;
        long sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr.get(i);
        }

        maxSum = sum;

        for (int i = K; i < arr.size(); i++) {
            sum += arr.get(i);
            sum -= arr.get(i - K);
            maxSum = Long.max(maxSum, sum);
        }

        return maxSum;

    }

}