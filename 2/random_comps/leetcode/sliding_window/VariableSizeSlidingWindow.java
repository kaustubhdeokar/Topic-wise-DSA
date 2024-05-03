package sliding_window;

public class VariableSizeSlidingWindow {
    public static void main(String[] args) {
        int[] arr = {4,1,1,1,2,3,5};
        int target = 5;
        int ans = maxSubarraySizeOfSumK(arr, target);
        System.out.println("ans:"+ans);
    }

    public static int maxSubarraySizeOfSumK(int[] arr, int target){

        int start = 0;
        int end = 0;
        int sum = 0;
        int maxSize = Integer.MIN_VALUE;

        while(start< arr.length && end <= arr.length){
            if(end < arr.length && sum < target){
                sum+=arr[end];
                end+=1;
            }
            else if(sum>target){
                sum -= arr[start];
                start += 1;
            }

            if(sum == target){
                maxSize = Integer.max(maxSize, end - start);
                System.out.println("limit:"+ (end - start));
                sum -= arr[start];
                start += 1;
            }
        }

        return maxSize;
    }

}