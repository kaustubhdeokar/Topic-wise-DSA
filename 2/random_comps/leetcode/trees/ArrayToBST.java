	public void createTreeOutOfArray(int[] nums){
	    int start = 0;
	    int end = nums.length-1;
	    createTreeOutOfArray(nums,start,end);
    }

    public void createTreeOutOfArray(int[] nums, int start, int end){
	    while(start<=end){
	        int mid = start + (end-start)/2;
            System.out.println(nums[mid]);
	        createTreeOutOfArray(nums,start,mid-1);
	        createTreeOutOfArray(nums,mid+1,end);
	        return; //very import, basic fucking thing , in a while loop loves going round and round.
        }
    }
