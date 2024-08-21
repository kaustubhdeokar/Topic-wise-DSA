package partitiontoequalsubset;

public class PartitionSumEqualSubsetRecursion {

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println("expected true, returned :"+canPartition(nums));    

        nums = new int[]{1,2,3,6};
        System.out.println("expected true, returned :"+canPartition(nums));   

        nums = new int[]{6,3,3,6};
        System.out.println("expected true, returned :"+canPartition(nums));   
    }

    public static boolean canPartition(int[] nums) {

        int sum = 0;
        for(int num: nums){
            sum+=num;
        }

        if(sum%2!=0) return false;
        
        return knapsack(nums, nums.length, sum/2);
    }

    public static boolean knapsack(int[] nums, int N, int sum){

        if(N==0||sum<0){
            return false;
        }
        
        if(sum == 0){
            return true;
        }

        if(nums[N-1]<=sum){
            return knapsack(nums, N-1, sum - nums[N-1]) ||
                    knapsack(nums, N-1, sum);
        }

        else{
            return knapsack(nums, N-1, sum);
        }

    }


}
