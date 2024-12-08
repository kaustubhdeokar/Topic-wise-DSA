package intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NonOverlappingElems {

    public int maxTwoEvents(int[][] events) {

        Comparator<int[]> comp = (c1, c2) -> Integer.compare(c1[0], c2[0]);
        PriorityQueue<int[]> q = new PriorityQueue<>(comp);
        Arrays.sort(events,(e1, e2)-> e1[0] - e2[0]);

        int maxVal = 0;
        int maxSum = 0;

        for(int[] event: events){

            while(!q.isEmpty() && q.peek()[0]<event[0]){
                maxVal = Math.max(maxVal, q.poll()[1]);
            }
            maxSum = Math.max(maxSum, maxVal + event[2]);
            q.add(new int[]{event[1], event[2]});
        }
        return maxSum;

    }

//    public int maxTwoEvents(int[][] events) {
//
//        Arrays.sort(events, (c1, c2) -> Integer.compare(c1[0], c2[0]));
//        int lastEndTime = -1;
//        int[][] dp = new int[events.length][3];
//        for(int[] d: dp) Arrays.fill(d, -1);
//        chooseTwo(dp, events, 0, lastEndTime, 0);
//
//        for(int[] d: dp){
//            for(int d1: d){
//                System.out.print(d1+" ");
//            }
//            System.out.println();
//        }
//
//        return 0;
//    }
//
//    public int chooseTwo(int[][] dp, int[][] events, int index, int lastEndTime, int totalIntervals)
//    {
//        if(totalIntervals == 2 || index >= events.length) return 0;
//
//        if(dp[index][totalIntervals] != -1) return dp[index][totalIntervals];
//
//        int[] curr = events[index];
//        int start = curr[0];
//        int end = curr[1];
//
//        int take = curr[2] + ((lastEndTime < start) ? chooseTwo(dp, events, index+1, end, totalIntervals+1):0);
//        int leave = chooseTwo(dp, events, index+1, lastEndTime, totalIntervals);
//        dp[index][totalIntervals] = Math.max(take, leave);
//
//        return dp[index][totalIntervals];
//    }

    public static void main(String[] args) {

        NonOverlappingElems nonOverlappingElems = new NonOverlappingElems();
        int[][] events = {{1,3,2},{4,5,2},{2,4,3}};
        nonOverlappingElems.maxTwoEvents(events);
    }
}
