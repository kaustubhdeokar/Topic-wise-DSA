package array.problems;

public class Lc1March25 {

    public int[] applyOperations(int[] nums) {
        int[] result = new int[nums.length];
        int count = 0;
        int i;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                if (nums[i] == nums[i + 1]) {
                    result[count] = nums[i] * 2;
                    i++;
                } else {
                    result[count] = nums[i];
                }
                count++;
            }
        }
        if (i != nums.length) {
            result[count] = nums[nums.length - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        Lc1March25 lc = new Lc1March25();
        int[] nums = {1, 2, 2, 1, 1, 0};
        lc.applyOperations(nums);

    }

}
