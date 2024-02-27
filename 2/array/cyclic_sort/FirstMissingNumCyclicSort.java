package cyclic_sort;

public class FirstMissingNumCyclicSort{

 public int missingNumber(int[] nums) {
        

        int ans = -1;
        cyclicSort(nums);

	   	//the first index for which i!=arr[i] -> ans.
   	
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i])
            {
                return i;
            }
            
        }
        
        return nums.length;
    }
    
    
    //in arr[i] == arrLen, skip it, else order. 
    //will be orderedlike [0,1,3] for [3,1,0]
   
    public void cyclicSort(int[] nums){
        
        int n = 0;
        int arrLen = nums.length;
        while(n<arrLen){
            while(!(nums[n]==n) && nums[n]!=arrLen){
                swap(nums,n,nums[n]);
            }
            n+=1;
        }
    }
    
    
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        
        FirstMissingNumCyclicSort first = new FirstMissingNumCyclicSort();
        int[] nums = {3,2,0};
        int ans = first.missingNumber(nums);
        for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(ans);
    }

}
