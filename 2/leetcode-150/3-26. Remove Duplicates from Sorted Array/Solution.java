public class Solution {


	public static void main(String[] args){

	    Solution s = new Solution();	
	    int[] nums = {0,0,1,1,1,2,2,3,3,4};
	    int res = s.removeDuplicates(nums);
	    System.out.println("expected 5, got "+res);
		
	}
    
	
	public int removeDuplicates(int[] nums) {

	if(nums.length==1){
	    return nums.length;
	}

	int curr = 0;
	int i=0;
	int j= i+1;

	while(j<=nums.length){

	    if(j==nums.length){
		nums[curr] = nums[i];
		curr+=1;
		break;
	    }

	    while(j<nums.length && nums[j]==nums[j-1]){
		j+=1;
	    }


	    nums[curr] = nums[i];
	    i=j;
	    j=i+1;
	    curr+=1;


	}


	int ans = curr;

	for(int k=curr+1;k<nums.length;k++){
	    nums[k] = -1;
	}

	return ans;

	}
}
