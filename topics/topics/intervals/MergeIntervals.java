package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // [[2,3],[4,5],[6,7],[8,9],[1,10]]
        // the reason we choose start time over end time.

        Comparator<int[]> comp = (c1, c2) -> Integer.compare(c1[0], c2[0]);
        Arrays.sort(intervals, comp);

        ArrayList<int[]> result = new ArrayList<>();
        int lastStart = -1;
        int lastEnd = -1;
        for (int[] interval : intervals) {
            int currStart = interval[0];
            int currEnd = interval[1];
            if (lastEnd == -1 || lastStart == -1) {
                lastStart = interval[0];
                lastEnd = interval[1];
            } else {
                if (lastEnd >= currStart) {
                    lastStart = Integer.min(lastStart, currStart);
                    lastEnd = Integer.max(lastEnd, currEnd);
                } else {
                    result.add(new int[]{lastStart, lastEnd});
                    lastStart = currStart;
                    lastEnd = currEnd;
                }
            }
        }
        result.add(new int[]{lastStart, lastEnd});
        int[][] resultArray = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
