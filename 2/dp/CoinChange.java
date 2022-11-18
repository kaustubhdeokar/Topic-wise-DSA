import java.util.*;

public class CoinChange {
    
    public static void main(String[] args) {
        
        int[] coins = {1,2,4};

        int change = 4;

        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        calculateWays(coins, change, 0, current, outerList);
        
        for (ArrayList<Integer> innerList : outerList) {
            for (Integer i : innerList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public static void calculateWays(int[] coins, int change, int curr, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result){

        if(change==0){
            current.add(curr);
            result.add(new ArrayList<>(current));
            current.remove(current.size()-1);
            return;
        }
        else if(curr!=0 && change>0){
            current.add(curr);
        }
        if(change<0){
            return;
        }

        for(int i=0;i<coins.length; i++){
            
            curr = coins[i];

            if((change-curr) >= 0)
            {
                calculateWays(coins, change-curr, curr, current, result);
            }
            else{
                if(current.size()>0){
                    current.remove(current.size()-1);
                }
                return;
            }

        }

    }

}
