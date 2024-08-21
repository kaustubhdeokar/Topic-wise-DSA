package fewestcoins;

import java.util.ArrayList;
import java.util.List;

public class FewestCoinsGFG {
    
    static List<Integer> minPartition(int N){
        int[] prices =  { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        
        int i = prices.length-1;
        List<Integer> coins = new ArrayList<>();
        
        while(i>=0){
            
            while(prices[i]<=N){
                N -= prices[i];
                coins.add(prices[i]);
            }    
            
            i-=1;
            
            
        }
        
        return coins;
        
    }

}
