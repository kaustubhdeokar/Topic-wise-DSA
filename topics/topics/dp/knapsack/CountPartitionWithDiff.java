package dp.knapsack;

import java.util.Arrays;
//https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=partitions-with-given-difference
//https://takeuforward.org/data-structure/count-partitions-with-given-difference-dp-18/
public class CountPartitionWithDiff {
    int countPartitions(int[] arr, int diff) {
        int N = arr.length;
        int currSum = 0;
        int totalSum = Arrays.stream(arr).sum();
        int[][] memo = new int[N+1][totalSum+1];
        for(int i=0;i<memo.length;i++){
            for(int j=0;j<memo[i].length;j++){
                memo[i][j] = -1;
            }
        }
        return countPartitionDiff(memo, arr, N, diff, currSum, totalSum);
    }

    int countPartitionDiff(int[][] memo, int[] arr, int N, int diff, int currSum, int otherSum)
    {
        if(N==0) {
            if(currSum >= otherSum && (currSum - otherSum) == diff) return 1;
            return 0;
        }

        if(memo[N][currSum]!=-1) {
            // System.out.println("found.");
            return memo[N][currSum];

        }


        int res1 = countPartitionDiff(memo, arr, N-1, diff, currSum + arr[N-1], otherSum - arr[N-1]);
        int res2 = countPartitionDiff(memo, arr, N-1, diff, currSum, otherSum);

        return memo[N][currSum] = res1 + res2;

    }

    public static void main(String[] args) {

    }

}
