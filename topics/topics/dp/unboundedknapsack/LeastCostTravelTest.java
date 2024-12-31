package dp.unboundedknapsack;

import org.junit.Assert;
import org.junit.Test;

public class LeastCostTravelTest {

    int[] costs;
    int[] days;

    @Test
    public void testcase1() {
        days = new int[]{1, 4, 6, 7, 8, 20};
        costs = new int[]{2, 7, 15};
        LeastCostTravel leastCostTravel = new LeastCostTravel(days, costs);
        Assert.assertEquals(11, leastCostTravel.minCostTickets(days, costs));
    }

    @Test
    public void testcase2() {
        days = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        costs = new int[]{2, 7, 15};
        LeastCostTravel leastCostTravel = new LeastCostTravel(days, costs);
        Assert.assertEquals(17, leastCostTravel.minCostTickets(days, costs));
    }

    @Test
    public void testcase3() {
        days = new int[]{1, 4, 6, 7, 8, 20};
        costs = new int[]{7, 2, 15};
        LeastCostTravel leastCostTravel = new LeastCostTravel(days, costs);
        Assert.assertEquals(6, leastCostTravel.minCostTickets(days, costs));
    }

    @Test
    public void testcase4() {
        days = new int[]{1, 2, 3, 4, 6, 8, 9, 10, 13, 14, 16, 17, 19, 21, 24, 26, 27, 28, 29};
        costs = new int[]{3, 14, 50};
        LeastCostTravel leastCostTravel = new LeastCostTravel(days, costs);
        Assert.assertEquals(50, leastCostTravel.minCostTickets(days, costs));
    }


}