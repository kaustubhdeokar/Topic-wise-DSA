package binarysearch;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://medium.com/@kaustubhd9/leetcode-pod-1760-minimum-limit-of-balls-in-a-bag-97a1fcf5bf39
public class MinimumBallsInBag {
    public static void main(String[] args) {

        int[] arr = {2,4,8,2};
        int maxOps = 4;
        // 2,4,16,2 , 4

        //to split to 8 (1
        // 2,4,8,8,2 - ops 1

        //to split to 6 (16/6 - 2.x - ceil(16/6)-1)
        // 2,4,6,6,4,2 - ops - 2

        //to split to 5
        // 2,4,5,5,5,1,2 - ops - 3

        //to split to 4
        // 2,4,4,4,4,4,2 - ops - 4

        //to split to 3.

        //all possible ways we can split 9 (1,8) (2,7)

//        bruteForce(arr, maxOps);
        System.out.println(binarySearch(arr, maxOps));

    }

    private static int binarySearch(int[] arr, int maxOps) {
        int high = Integer.MIN_VALUE;
        for(int i: arr){
            high = Math.max(high, i);
        }
        int minBallsAchieved = Integer.MAX_VALUE;
        int low = 1;

        while(low<=high){
            int split = low + (high - low)/2;
            int count = 0;
            for(int i: arr){
                if(split > i) continue;
                count += Math.ceil(i/(split*1.0)) - 1;
            }
            if(count <= maxOps) {
                minBallsAchieved = Integer.min(minBallsAchieved, (int)split);
                high = split - 1;
            }
            else{
                low = split + 1;
            }
        }

        return minBallsAchieved;

    }

    private static void bruteForce(int[] arr, int maxOps) {
        Comparator<Integer> comp = (c1, c2) -> Integer.compare(c2,c1);
        PriorityQueue<Integer> q = new PriorityQueue<>(comp);
        for(int a: arr) q.add(a);
        System.out.println(calculateMinBallsInBag(q, maxOps, 0));
    }

    private static int calculateMinBallsInBag(PriorityQueue<Integer> q, int maxOps, int ops) {

        if(ops==maxOps) {
            return q.peek();
        }

        int toSplit = q.remove();
        int maxYet = Integer.MAX_VALUE;
        for (int i = 1; i <= toSplit / 2; i++) {
            int b = toSplit - i;
            q.add(i); q.add(b);
            maxYet = Integer.min(maxYet, calculateMinBallsInBag(q, maxOps, ops+1));
            q.remove(i);q.remove(b);
        }
        return maxYet;


    }
}
