package sliding_window;

import java.util.*;

public class FirstNegativeNumber {
    
    public static void main(String[] args) {
        
        long[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        long[] result = printFirstNegativeInteger(arr, arr.length, 3);

        for(long num: result){
            System.out.print(num+" ");
        }
    }

    public static long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<K;i++){
            if(A[i]<0) q.add(i);
        }
        
        long[] ans = new long[N-K+1];
        int idx = 0;
        
        int start = 0;
        int end = K-1;
        
        while(end<N){
            
            if(q.isEmpty()){
                ans[idx++] = 0;
            }
            else{
                ans[idx++] = A[q.peek()];
            }
            
            if(!q.isEmpty() && q.peek() == start)
            q.remove();
            
            start += 1;
            end += 1;
            
            if(end < N && A[end] < 0)
                q.add(end);
        }
        
        return ans;
        
    }

}
