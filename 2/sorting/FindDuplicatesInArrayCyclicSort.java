class FindDuplicatesInArrayCyclicSort {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        cyclicSort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                list.add(nums[i]);
        }
        return list;
    }
    
    public void cyclicSort(int[] nums){
        
        int n = 0;
        int arrLen = nums.length;
        while(n<arrLen){
            while(!(nums[n]==n+1) && nums[n]!=nums[nums[n]-1]){
                swap(nums,n,nums[n]-1);
            }
            n+=1;
        }
        
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
