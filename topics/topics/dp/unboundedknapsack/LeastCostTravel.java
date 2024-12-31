package dp.unboundedknapsack;

public class LeastCostTravel {

    int[] days;
    int[] costs;

    public LeastCostTravel(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
    }

    public static void main(String[] args) {
        LeastCostTravel leastCostTravel = new LeastCostTravel();
        leastCostTravel.minCostTickets();
    }

    public LeastCostTravel() {

    }

    private void minCostTickets() {
        minCostTickets(days, costs);
    }

    public int minCostTickets(int[] days, int[] costs) {

        int dLen = days.length;
        int maxDay = days[dLen - 1];
        int[] travel = new int[maxDay + 1];
        int ptr = 1;

        for (int day : days) {
            while (day > ptr) {
                travel[ptr] += travel[ptr - 1];
                ptr += 1;
            }
            travel[ptr] = travel[ptr - 1] + costs[0];

            if (ptr >= 7) {
                travel[ptr] = Integer.min(travel[ptr], travel[ptr - 7] + costs[1]);
            } else {
                travel[ptr] = Integer.min(travel[ptr], travel[0] + costs[1]);
            }

            if (ptr >= 30) {
                travel[ptr] = Integer.min(travel[ptr], travel[ptr - 30] + costs[2]);
            } else {
                travel[ptr] = Integer.min(travel[ptr], travel[0] + costs[2]);
            }
            ptr += 1;
        }
        return travel[maxDay];

    }
}
