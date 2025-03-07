package intervals;

import java.util.ArrayList;

public class InsertIntervals {
    public static void main(String[] args) {

    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while( i < n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }
        while( i < n && intervals[i][0] <=newInterval[1])
        {
            newInterval[0] = Math.min(newInterval[0] , intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1] , intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        while(i < n){
            ans.add(intervals[i]);
            i++;
        }
        int ret[][] = new int[ans.size()][2];
        for(i = 0; i < ret.length; i++){
            ret[i] = ans.get(i);
        }
        return ret;
    }
}
