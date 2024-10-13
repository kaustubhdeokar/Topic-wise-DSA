package intervals;

import java.util.Arrays;

public class MinimumGroupIntervals {

    public static void main(String[] args) {

        int[][] intervals = {{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];

        int stItr = 0;
        int etItr = 0;
        for (int[] interval : intervals) {
            startTime[stItr++] = interval[0];
            endTime[etItr++] = interval[1];
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        stItr = 0;
        etItr = 0;
        int count = 0;
        int maxCount = 0;

        while (etItr < endTime.length) {
            while (stItr < startTime.length && startTime[stItr] <= endTime[etItr]) {
                count += 1;
                maxCount = Integer.max(maxCount, count);
                stItr += 1;
            }
            count -= 1;
            etItr += 1;
        }

        System.out.println(maxCount);
    }
}
