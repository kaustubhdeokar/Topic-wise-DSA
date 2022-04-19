public class CyclicSort{

	public static void main(String[] args){
	
	//WHENEVER GIVEN RANGE FROM 1-N, use cyclic sort. 
	
	    public static void main(String[] args) throws java.lang.Exception {

        int[] nums = {3, 5, 2, 1, 4};
        int n = 0;
        while (n < nums.length) {
            while (!(nums[n] == n + 1)) {
                swap(nums, n, nums[n]-1);
            }
            n+=1;
        }

    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

	
			
	}
	
}
