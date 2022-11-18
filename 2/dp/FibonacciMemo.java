import java.util.*;

public class FibonacciMemo{

    public static void main(String[] args){

        int n = 5;
        int[] fib = new int[n+1];

        fibonacciWithMemotization(n, fib);

        for(int i:fib){
            System.out.print(i+" ");
        }

    }

    /*
     memoization is top down manner. 
     start from n, come to the base case. 
     */

    public static int fibonacciWithMemotization(int n, int[] fib){

        if(n>=0){

            if(n==0 || n==1){
                fib[n] = n;
                return fib[n];
            }

            fib[n] = fibonacciWithMemotization(n-1, fib) + fibonacciWithMemotization(n-2, fib);
            return fib[n];

        }

        return -1;
    }



}