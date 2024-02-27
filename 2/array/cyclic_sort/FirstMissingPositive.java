package cyclic_sort;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        cyclicSort(nums);

        int j=1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=j)
                return j;
            j+=1;
        }
        return j;
    }

    public void cyclicSort(int[] nums){
        int n = 0;
        int arrLen = nums.length;
        while(n<nums.length){
            if(nums[n]>0 && nums[n]<=arrLen && nums[n]!=nums[nums[n]-1])
                swap(nums,n,nums[n]-1);
            else
                n+=1;
        }
    }
    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }

    public static void main(String[] args) {
        
        FirstMissingPositive first = new FirstMissingPositive();
        int[] nums = {3,4,-1,1};
        int ans = first.firstMissingPositive(nums);
        for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(ans);
    }

}
