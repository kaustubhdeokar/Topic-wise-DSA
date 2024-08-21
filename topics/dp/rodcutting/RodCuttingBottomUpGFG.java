package rodcutting;

public class RodCuttingBottomUpGFG {
    
    public int cutRod(int price[], int n) {
        int[] arr = new int[n];
        for(int i=1;i<=n;i++){
            arr[i-1] = i;
        }
        int[][] dp = new int[n+1][n+1];
        return cutRod(dp, price, arr, n, n);
    }
    
    public int cutRod(int[][] dp, int[] price, int[] arr, int N, int totalLen){
        for(int i=1;i<=N;i++){
            for(int j=1;j<=totalLen;j++){
                
                if(j>=i){
                    dp[i][j] = Integer.max(price[i-1]+dp[i][j-arr[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][totalLen];
    }

    public static void main(String[] args) {
        
        RodCuttingBottomUpGFG rod = new RodCuttingBottomUpGFG();
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(rod.cutRod(price, price.length));
    }

}
