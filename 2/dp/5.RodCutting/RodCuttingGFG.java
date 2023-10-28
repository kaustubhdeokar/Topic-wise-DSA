public class RodCuttingGFG {
    
    public int cutRod(int price[], int n) {
        int[] arr = new int[n];
        for(int i=1;i<=n;i++){
            arr[i-1] = i;
        }
        return cutRod(price, arr, n, n);
    }
    
    public int cutRod(int[] price, int[] arr, int N, int totalLen){
        if(N==0 || totalLen==0){
            return 0;
        }
        if(totalLen >= N){
            return Integer.max(price[N-1]+cutRod(price, arr, N, totalLen - arr[N-1]), 
                               cutRod(price, arr, N-1, totalLen));   
        }
        else{
            return cutRod(price, arr, N-1, totalLen);
        }
    }

    public static void main(String[] args) {
        
        RodCuttingGFG rod = new RodCuttingGFG();
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(rod.cutRod(price, price.length));
    }

}
