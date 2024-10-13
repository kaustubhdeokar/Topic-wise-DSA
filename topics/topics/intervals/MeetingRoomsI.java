package intervals;

import java.util.Arrays;
import java.util.LinkedList;

public class MeetingRoomsI {

    public static void main(String[] args) {

        int[][] intervals = {{8, 10}, {15, 18}, {1, 3}, {2, 6}};
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> linkedList = new LinkedList<>();

        for (int[] interval : intervals) {
            if (linkedList.isEmpty() || linkedList.getLast()[1] < interval[0]) {
                linkedList.add(interval);
            } else {
                int[] last = linkedList.getLast();
                if (last[1] >= interval[0]) {
                    last[1] = Integer.max(last[1], interval[1]);
                }
            }
        }

        int[][] answer = linkedList.toArray(new int[linkedList.size()][]);
        for (int[] interval : answer) {
            System.out.println(interval[0]+":"+interval[1]);
        }
    }

}
