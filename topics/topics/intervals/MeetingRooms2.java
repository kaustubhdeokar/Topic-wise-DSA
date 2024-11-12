package intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    public static void main(String[] args) {

//        int[][] intervals = {{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};

//        System.out.println(maxCount);

        MeetingRooms2 mr2 = new MeetingRooms2();
        mr2.minMeetingRooms();
    }

    public int minMeetingRooms() {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};

        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        //this stores the end time of the meetings in ascending order.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //during final meeting
        //pq will be (30,20,10) and least end time will be 10 (meeting 2) hence, that will be popped.
        int room = 0;
        for (int i = 0; i < intervals.length; i++) {
            pq.offer(intervals[i][1]);
            if (intervals[i][0] < pq.peek()) room++;
            else {
                pq.poll();
            }
        }
        return room;


    }

}
