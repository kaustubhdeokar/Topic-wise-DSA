public class Knapsack01 {
    
    public static void main(String[] args) {
      
        int N = 3;
        int W = 4;
        int val[] = {1,2,3};
        int wt[] = {4,5,1};

        System.out.println("Expected is 3, actual is :"+knapSack(W, wt, val, N));

    }

    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         
        if(W==0 || n==0)
            return 0;
            
        if(wt[n-1]<=W){
            return Integer.max(
            val[n-1]+knapSack(W-wt[n-1], wt, val, n-1),
            knapSack(W, wt, val, n-1));
        }
        else{
            return knapSack(W, wt, val, n-1);
        }
         
    } 

}
