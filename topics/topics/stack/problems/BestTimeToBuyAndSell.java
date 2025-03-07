package stack.problems;

// blind 75: 2
public class BestTimeToBuyAndSell {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        //just keep a variable highest and start from right.
        int max = -1;
        int maxProfit = -1;
        for (int i = prices.length-1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            }
            int currProfit = max - prices[i];
            maxProfit = Math.max(maxProfit, currProfit);

        }

        System.out.println("max profit:" + maxProfit);

    }

}
