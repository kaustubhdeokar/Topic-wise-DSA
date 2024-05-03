package stack;

import java.util.*;

public class BestTimeToBuyAndSellStock {
    
    public static void main(String[] args) {

        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
        //System.out.println("expected 5, got:"+maxProfit(prices));
        int N = prices.length;

        int[] res = bestTimeToBuyAndSellStock.stockSpan(N, prices);
        System.out.println("expected :1 1 2 1 4 1");
        System.out.print("current  :");
        for(int r:res){
            System.out.print(r+" ");
        }
        System.out.println();

        prices = new int[]{100, 80, 60, 70, 60, 75, 85};
        N = prices.length;
        res = bestTimeToBuyAndSellStock.stockSpan(N, prices);
        System.out.println("expected :1 1 1 2 1 4 6");
        System.out.print("current  :");
        for(int r:res){
            System.out.print(r+" ");
        }


    }

    public int maxProfit(int[] prices) {
      
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


    public int[] stockSpan(int N, int[] prices){
        
        int[] result = new int[N];
        Stack<MapStockToDay> lesserThanCurr = new Stack<>();

        for(int i=0;i<N;i++){
            if(lesserThanCurr.isEmpty()){
                result[i] = 1;
            }
            else if(lesserThanCurr.peek().stockPrice > prices[i]){
                result[i] = 1;
            }
            else{
                while(lesserThanCurr.peek().stockPrice < prices[i]){
                    lesserThanCurr.pop();
                }
                if(lesserThanCurr.isEmpty()){
                    result[i] = i;
                }
                else{
                    result[i] = i - lesserThanCurr.peek().day;
                   
                }
            }
            lesserThanCurr.push(new MapStockToDay(prices[i],i));
        }

        return result;
    }

}
