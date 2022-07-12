import java.util.Comparator;
import java.util.PriorityQueue;

public class ActivitySelection {

    //Here the logic is to sort these activities by their end time. and not the start, or the difference.

    public static int activitySelection(int start[], int end[], int n) {
        Comparator<Activity> compareStartTimes =
                (a1, a2) -> Integer.compare(a1.end, a2.end);


        PriorityQueue<Activity> q = new PriorityQueue<>(compareStartTimes);
        // 1,2..2,3..3,4..5,6

        for (int i = 0; i < start.length; i++) {
            q.add(new Activity(start[i], end[i]));
        }

        int tasksDone = 1;
        Activity current = q.poll();
        assert current != null; // q size is at least 1, won't be true.
        int currEndTime = current.end;

        while (!q.isEmpty()) {

            Activity next = q.poll();

            if (next.start > currEndTime) {
                currEndTime = next.end;
                tasksDone += 1;
            }
        }

        return tasksDone;
    }

    static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
