import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JobSequencing {

    public int maxProfitByJobSequencing(Job arr[], int n) {

        Comparator<Job> compareByDeadlineAndProfit = (Job j1, Job j2) ->
                j1.deadline == j2.deadline ?
                        Integer.compare(j2.profit, j1.profit) :
                        Integer.compare(j2.deadline, j1.deadline);

        PriorityQueue<Job> heap = new PriorityQueue<>(compareByDeadlineAndProfit);
        heap.addAll(Arrays.asList(arr));

        int jobsDone = 0;
        int profit = 0;

        for (int day = n; day >= 0; day--) {
            Job top = heap.peek();
            if (top.deadline >= day) {
                top = heap.poll();
                profit += top.profit;
                jobsDone += 1;
            } else {
                continue;
            }
        }

        return -1;
    }

    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "id=" + id +
                    ", profit=" + profit +
                    ", deadline=" + deadline +
                    '}';
        }
    }

    public static void main(String[] args) {
        JobSequencing jobSequencing = new JobSequencing();
        Job[] arr = {new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30)};
        jobSequencing.maxProfitByJobSequencing(arr, 4);
    }

}
