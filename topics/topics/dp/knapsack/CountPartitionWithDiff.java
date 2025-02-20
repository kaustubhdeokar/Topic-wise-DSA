package dp.knapsack;

import java.util.*;

//https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=partitions-with-given-difference
//https://takeuforward.org/data-structure/count-partitions-with-given-difference-dp-18/
public class CountPartitionWithDiff {
    int countPartitions(int[] arr, int d) {
        int N = arr.length;
        int currSum = 0;
        int totalSum = Arrays.stream(arr).sum();
        List<Map<Integer, Integer>> cache = new ArrayList<>();
        for (int i = 0; i < arr.length + 1; i++) cache.add(new HashMap<>());
        return countPartitionDiff(cache, arr, N, d, currSum, totalSum);
    }


    int countPartitionDiff(List<Map<Integer, Integer>> memo, int[] arr, int N, int diff, int currSum, int otherSum) {
        if (N <= 0) {
            if (currSum >= otherSum && (currSum - otherSum) == diff) return 1;
            return 0;
        }

        if (memo.get(N).containsKey(currSum)) {
            return memo.get(N).get(currSum);
        }


        int res1 = countPartitionDiff(memo, arr, N - 1, diff, currSum + arr[N - 1], otherSum - arr[N - 1]);
        int res2 = countPartitionDiff(memo, arr, N - 1, diff, currSum, otherSum);

        memo.get(N).put(currSum, res1 + res2);

        return memo.get(N).get(currSum);

    }

    public static void main(String[] args) {
        CountPartitionWithDiff countPartitionWithDiff = new CountPartitionWithDiff();
        int[] arr = {5, 2, 6, 4};
        int d = 3;
        int res = countPartitionWithDiff.countPartitions(arr, d);
        System.out.println(res);
    }

}
