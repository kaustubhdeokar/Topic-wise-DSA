public class SubsetsWithSumK {
    
    public static void main(String[] args) {
    
        int[] nums = {7, 3, 2, 5, 8 };
        int[] count = {0};
        int k = 14;
        // System.out.println("expected true, got :"+ formSubsets(nums,k, count));

        k = 10;
        count = new int[]{0};
        nums = new int[]{2,3,5,6,8,10};
        System.out.println("expected true, got :"+ formSubsets(nums, k,count));

    }

    public static int formSubsets(int[] nums, int k,int[] count) {
        
        recursiveSolution(nums, nums.length, k, count);
        return count[0];
    }
    
    public static void recursiveSolution(int[] nums, int n, int sum, int[] count){
        
        System.out.println("sum:"+sum);
        System.out.println("n:"+n);

        if(sum==0){
            count[0]+=1;
            return;
        }
        if(n==0 || sum<0){
            return;
        }

        if(sum>=nums[n-1]){
            recursiveSolution(nums, n-1, sum - nums[n-1], count);
            recursiveSolution(nums, n-1, sum, count);
        }
        else{
            recursiveSolution(nums, n-1, sum, count);
        }

    }

}
