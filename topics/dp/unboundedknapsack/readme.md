The difference between bounded and unbounded knapsack is that in an unbounded knapsack, the same item can be used 
again and again. 

```java  
    Knapsack sample code

    void knapsack(int[][] dp, int wt[], int[] val, int n, int W){
        
        if(W >= wt[n]){
            return Integer.max(val[n]+knapsack(dp, wt, val, n-1, W-wt[n]), knapsack(dp, wt, val, n -1 , W))    
        }
        else{
            return knapsack(dp, wt, val, n-1, W);
        }
    }
    
```

But in unbounded knapsack code. 

```java  
    Knapsack sample code

    void unboundedknapsack(int[][] dp, int wt[], int[] val, int n, int W){
        
        if(W >= wt[n]){
            return Integer.max(val[n]+knapsack(dp, wt, val, n, W-wt[n]), knapsack(dp, wt, val, n -1 , W))    
        }
        else{
            return knapsack(dp, wt, val, n-1, W);
        }
    }
    
```
