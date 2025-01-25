package dp.unboundedknapsack;

public class MinCoinsGreedy {

    public static void main(String[] args) {
        MinCoinsGreedy minCoinsGreedy = new MinCoinsGreedy();
        int[] coins = {638, 414, 105, 0, 325, 315, 209, 24, 68, 409, 611};
        int sum = 845;
        System.out.println(minCoinsGreedy.minCoins(coins, sum));
    }

    int minCoins(int[] coins, int sum) {

        int n = coins.length;
        int[] memo = new int[sum + 1];
        for (int i = 1; i <= sum; i++)
            memo[i] = Integer.MAX_VALUE;
        memo[0] = 0;


        for (int s = 1; s <= sum; s++) {
            for (int i = 0; i < n; i++) {
                if (s >= coins[i]) {
                    int prev = memo[s - coins[i]];
                    if (prev != Integer.MAX_VALUE && (prev + 1) < memo[s])
                        memo[s] = prev + 1;
                }
            }
        }

        if (memo[sum] == Integer.MAX_VALUE)
            return -1;

        return memo[sum];
    }
}
