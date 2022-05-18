class Solution {
    public int rob(int[] cost) {

        int n = cost.length;
        
        if(n==1)
            return cost[0];

        int[] cost1 = Arrays.copyOfRange(cost,0,n-1);
        int[] cost2 = Arrays.copyOfRange(cost,1,n);
        
        return Integer.max(maxRobbery(cost1),maxRobbery(cost2));

    }
    
    public int maxRobbery(int[] cost){

        int len = cost.length;
        
        if(len == 1) return cost[0];
        if(len == 2) return Integer.max(cost[0],cost[1]);
        
        cost[1] = Integer.max(cost[0],cost[1]);

        for(int i=2;i<len;i++){
            cost[i] = Integer.max(cost[i]+cost[i-2],cost[i-1]);    
        }
        
        return Integer.max(cost[cost.length-1],cost[cost.length-2]);
    }
    
}
