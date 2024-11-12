package intervals;

import java.util.Arrays;

public class OverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        // sorting by the end
        //12 13 23 34
        //i   j
        // while intervals[j][0]< interval[curr][1], toremove+=1, j++ //check boundary
        // if intervals[j][0] > interval[curr][1], curr = j
        Arrays.sort(intervals, (a, b)->
        {
            return Integer.compare(a[1], b[1]);
        });

        int i =0;
        int ans = 0;
        int n = intervals.length;
        while(i<n){
            int end = intervals[i][1];
            i++;
            while(i<n && intervals[i][0] < end){
                i++;
                ans ++;
            }
        }

        return ans;
    }
}
