public class BestTimeToBuyAndSellStock {
    
    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        System.out.println("expected 5, got:"+maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
      
        int minSoFar = prices[0];
        int maxProfit = 0;

        for(int i=1;i<prices.length;i++){
            if(minSoFar<prices[i]){
                maxProfit = Integer.max(maxProfit, prices[i]-minSoFar);
            }
            minSoFar = Integer.min(minSoFar, prices[i]);
        }
        return maxProfit;
    }

}
