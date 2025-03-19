package array.problems;

public class MinOps {
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                count += 1;
                for (int j = i; j < i + 3; j++) {
                    nums[j] ^= 1;
                }

            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) return -1;
        }
        return count;
    }

    public int minOperationsEfficient(int[] nums) {
        int count = 0;
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            if (nums[i] == 0) {
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                count += 1;
            }
        }
        if(nums[len-1] == 0 || nums[len-2]==0) return -1;
        return count;

    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 0, 0};
        MinOps min = new MinOps();
        int res = min.minOperations(arr);
        System.out.println("res:"+res);
    }
}
