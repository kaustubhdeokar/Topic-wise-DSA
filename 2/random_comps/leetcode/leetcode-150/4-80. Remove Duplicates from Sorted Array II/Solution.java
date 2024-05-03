class Solution {


	public static void main(String[] args){

	    Solution s = new Solution();	
	    int[] nums = {0,0,1,1,1,1,2,3,3,3,3,3,3,3,3,4,5,6,7,8};
	    int res = s.removeDuplicates(nums);
	    System.out.println("expected 12, got "+res);
		
	}

	public int removeDuplicates(int[] nums) {

	if(nums.length<=2){
	    return nums.length;
	}
	int maxCountAllowed = 2;

	int curr = 0;
	int i= 0;
	int j= 0;


	while(j<nums.length){
	    
	    int currentNum = nums[i];
	    int currCount = 0;
	    //System.out.println("currentNum:"+currentNum);
	    while(j<nums.length && nums[j] == currentNum){
		if(currCount < maxCountAllowed){
		    nums[curr] = currentNum;
		    currCount +=1;
		    curr+=1;
		}
		j+=1;
	    }
	    i=j;
	    //System.out.println("change:"+i);
	}

	//System.out.println("curr:"+curr);

	int ans = curr;

	for(int k=curr+1;k<nums.length;k++){
	    nums[k] = -1;
	}

	return ans;

	}
	}
