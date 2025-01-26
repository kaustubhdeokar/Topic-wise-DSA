package dp.stocks;

public class BuyAndSellAtMostKTimes {

    public static void main(String[] args) {

        int[] arr = new int[]{3,2,6,5,0,3};
        int k = 2;
        BuyAndSellKTimes buyAndSellKTimes = new BuyAndSellKTimes();
        System.out.println(buyAndSellKTimes.memoizedSolution(arr, k));

    }

}
