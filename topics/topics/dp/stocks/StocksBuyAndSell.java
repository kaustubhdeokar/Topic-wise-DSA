package dp.stocks;

import java.util.Arrays;

public class StocksBuyAndSell {
    public static void main(String[] args) {
        StocksBuyAndSell stocksBuyAndSell = new StocksBuyAndSell();
        int[] arr;
        int[][] memo;
        int res;

//        arr = new int[]{1, 2, 3, 4, 5};
//        memo = new int[arr.length][2];
//        for (int[] d : memo) {
//            Arrays.fill(d, -1);
//        }
//        res = stocksBuyAndSell.maxProfitForMultipleBuyAndSellMemoization(memo, 1, arr, 0);
//        System.out.println(res);
//        res = stocksBuyAndSell.maxProfitForMultipleBuyAndSellTabulation(arr);
//        System.out.println(res);

        arr = new int[]{2,1,4,5,2,9,7};
        memo = new int[arr.length][2];
        for (int[] d : memo) {
            Arrays.fill(d, -1);
        }
        res = stocksBuyAndSell.atMax2Transactions(memo, 1, arr, 0, 2);
        System.out.println(res);

//        arr = new int[]{1, 2, 3, 0, 2};
//        res = stocksBuyAndSell.maxProfitForMultipleBuyAndSellTabulationWithCoolDown(arr, 1);
//        System.out.println(res);

    }

    private int atMax2Transactions(int[][] memo, int buyChoice, int[] arr, int idx, int transactions) {

        if (idx == arr.length || transactions == 0) return 0;
        if (memo[idx][buyChoice] != -1) return memo[idx][buyChoice];

        int res;
        if (buyChoice == 1)
        {
            res = Math.max(-arr[idx] + atMax2Transactions(memo, buyChoice ^ 1, arr, idx + 1, transactions),
                    atMax2Transactions(memo, buyChoice, arr, idx + 1, transactions));
        }
        else
        {
            res = Math.max(arr[idx] + atMax2Transactions(memo, buyChoice ^ 1, arr, idx + 1, transactions - 1),
                    atMax2Transactions(memo, buyChoice, arr, idx + 1, transactions));
        }
        memo[idx][buyChoice] = res;
        return memo[idx][buyChoice];
    }

    int maxProfitForMultipleBuyAndSellMemoization(int[][] memo, int buyChoice, int[] arr, int idx) {
        // either to buyChoice or not buyChoice
        if (idx == arr.length) return 0;
        if (memo[idx][buyChoice] != -1) return memo[idx][buyChoice];

        int res;
        if (buyChoice == 1) {
            res = Math.max(-arr[idx] + maxProfitForMultipleBuyAndSellMemoization(memo, buyChoice ^ 1, arr, idx + 1),
                    maxProfitForMultipleBuyAndSellMemoization(memo, buyChoice, arr, idx + 1));
        } else {
            res = Math.max(arr[idx] + maxProfitForMultipleBuyAndSellMemoization(memo, buyChoice ^ 1, arr, idx + 1),
                    maxProfitForMultipleBuyAndSellMemoization(memo, buyChoice, arr, idx + 1));
        }
        memo[idx][buyChoice] = res;
        return memo[idx][buyChoice];
    }

    int multipleBuySellAtMax2TransMemoization
            (int[][] memo, int buyChoice, int[] arr, int idx, int buyTransactions, int sellTransactions) {
        // either to buyChoice or not buyChoice
        if (idx == arr.length) return 0;
        if (memo[idx][buyChoice] != -1) return memo[idx][buyChoice];

        int res = -1001;
        if (buyChoice == 1 && buyTransactions > 0) {
            res = Math.max(-arr[idx] + multipleBuySellAtMax2TransMemoization(memo, buyChoice ^ 1, arr,
                            idx + 1, buyTransactions - 1, sellTransactions),
                    multipleBuySellAtMax2TransMemoization(memo, buyChoice, arr, idx + 1, buyTransactions, sellTransactions));
        } else if (sellTransactions < buyTransactions) {
            res = Math.max(arr[idx] + multipleBuySellAtMax2TransMemoization(memo, buyChoice ^ 1, arr,
                            idx + 1, buyTransactions, sellTransactions - 1),
                    multipleBuySellAtMax2TransMemoization(memo, buyChoice, arr, idx + 1, buyTransactions, sellTransactions));
        }

        memo[idx][buyChoice] = res;
        return memo[idx][buyChoice];

    }

    int maxProfitForMultipleBuyAndSellTabulation(int[] arr) {
        int[][] dp = new int[arr.length + 1][2];
        dp[arr.length][0] = 0;
        dp[arr.length][1] = 0;
        boolean toBuy = true;

        for (int i = arr.length - 1; i >= 0; i--) {
            //0->buy, 1->sell.
            int profit;
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    profit = Math.max(-arr[i] + dp[i + 1][j ^ 1], dp[i + 1][j]);
                } else {
                    profit = Math.max(arr[i] + dp[i + 1][j ^ 1], dp[i + 1][j]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][0];
    }

    int maxProfitForMultipleBuyAndSellTabulationWithCoolDown(int[] arr, int coolDown) {

        int[][] dp = new int[arr.length + 2][2];
        dp[arr.length][0] = 0;
        dp[arr.length][1] = 0;
        dp[arr.length + 1][0] = 0;
        dp[arr.length + 1][1] = 0;
        boolean toBuy = true;

        for (int i = arr.length - 1; i >= 0; i--) {
            //0->buy, 1->sell.
            int profit;
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    profit = Math.max(-arr[i] + dp[i + 1][j ^ 1], dp[i + 1][j]);
                } else {
                    profit = Math.max(arr[i] + dp[i + 1 + coolDown][j ^ 1], dp[i + 1][j]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][0];
    }


}
