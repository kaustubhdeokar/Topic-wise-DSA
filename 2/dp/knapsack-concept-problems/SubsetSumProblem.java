public class Solution {
    public int solve(int[] arr, int B) {
     boolean subsetPresent = false;

        int[][] dp = new int[arr.length+1][B+1];
        for(int i=0;i<=arr.length;i++)
            Arrays.fill(dp[i],-1);

        if(findSubset(dp,arr,0,B)==B)
        return 1;
        else 
        return 0;

    }

    public int findSubset(int[][] dp, int[] arr, int index, int sum){
        
        if(index >= arr.length || sum <= 0)
            return 0;

        if(dp[index][sum]!=-1)
            return dp[index][sum];  

        if(arr[index]<=sum){
            dp[index][sum] = Integer.max(arr[index]+findSubset(dp,arr,index+1,sum-arr[index]),
                                                    findSubset(dp,arr,index+1,sum));
        }
        else{
            dp[index][sum] = findSubset(dp,arr,index+1,sum);
        }

        return dp[index][sum];
    }
}
