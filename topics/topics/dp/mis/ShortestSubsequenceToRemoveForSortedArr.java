package dp.mis;

import java.util.Arrays;

public class ShortestSubsequenceToRemoveForSortedArr {

    public int findLengthOfShortestSubarray(int[] arr) {

        //increasing subsequence problem.
        //ans = new int[arr.length];
        //for ith element,
        // j-> (0-(i-1)) elems
        // if arr[j] <= arr[i] , ans[i] = max(ans[i], arr[j]+1);
        //finally ans = ans.length - ans[n-1]

        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<=ans[i]){
                    ans[i] = Integer.max(ans[i], ans[j]+1);
                }
            }
        }

        int max = -1;
        for(int a: ans){
            System.out.print(a+" ");
            max = max<a ? a: max;
        }

        return ans.length - max;
    }

    public static void main(String[] args) {

    }
}
