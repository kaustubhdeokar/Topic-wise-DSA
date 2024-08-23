The difference between bounded and unbounded dp.knapsack is that in an unbounded dp.knapsack, the same item can be used 
again and again. 

```java  
    Knapsack sample code

    void dp.knapsack(int[][] dp, int wt[], int[] val, int n, int W){
        
        if(W >= wt[n]){
            return Integer.max(val[n]+dp.knapsack(dp, wt, val, n-1, W-wt[n]), dp.knapsack(dp, wt, val, n -1 , W))    
        }
        else{
            return dp.knapsack(dp, wt, val, n-1, W);
        }
    }
    
```

But in unbounded dp.knapsack code. 

```java  
    Knapsack sample code

    void dp.unboundedknapsack(int[][] dp, int wt[], int[] val, int n, int W){
        
        if(W >= wt[n]){
            return Integer.max(val[n]+dp.knapsack(dp, wt, val, n, W-wt[n]), dp.knapsack(dp, wt, val, n -1 , W))    
        }
        else{
            return dp.knapsack(dp, wt, val, n-1, W);
        }
    }
    
```
