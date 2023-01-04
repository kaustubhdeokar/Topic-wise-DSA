import java.util.*;

public class SubsetSumRecursion{

    static Boolean isSubsetSum(int N, int arr[], int sum){
        
        if(sum==0)
            return true;
        if(sum<0 || N==0)
            return false;
        
        if(arr[N-1]<=sum){
            return isSubsetSum(N-1, arr, sum - arr[N-1]) || isSubsetSum(N-1, arr, sum);
        }
        else{
            return isSubsetSum(N-1, arr, sum);
        }
        
    }

    public static void main(String[] args) {
        
        int n = 6;
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        System.out.println("expected true, got:"+isSubsetSum(n, arr, sum));
        
        sum = 30;
        System.out.println("expected false, got:"+isSubsetSum(n, arr, sum));
    }

}