package cyclic_sort;

//https://leetcode.com/problems/find-the-duplicate-number/


public class DuplicateNumCyclicSort{
  
  
  public int findDuplicate(int[] arr) {
        
        cyclicSort(arr);

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i+1)
                return arr[i];
        }
        return -1;
    }
    
    private void cyclicSort(int[] nums) {
        int n = 0;
        while (n < nums.length) {
            while (!(nums[n] == n+1) && nums[n] != nums[nums[n]-1]) {
                swap(nums, n, nums[n]-1);
            }
            n += 1;
        }
    }

    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1,3,4,2,2};
        DuplicateNumCyclicSort dup =new DuplicateNumCyclicSort();
        int res = dup.findDuplicate(nums);
        System.out.println(res);
    }

}
