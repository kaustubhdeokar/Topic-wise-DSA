public class FibonacciTabulation {
    public static void main(String[] args) {
        
        int n = 5;
        int[] fib = new int[n+1];

        fibnoacci(n, fib);
        
        for(int i:fib){
            System.out.print(i+" ");
        }

    }

    public static void fibnoacci(int n, int[] fib){

        fib[0] = 0;
        fib[1] = 1;
        for(int i=2;i<=n;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }

    }

}
