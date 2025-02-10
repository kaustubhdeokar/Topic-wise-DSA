package binarysearch;

public class UpperLowerBound {
    public static void main(String[] args) {
        UpperLowerBound upperLowerBound = new UpperLowerBound();
        int[] res = upperLowerBound.calculate(new int[]{2, 2}, 3);
        System.out.println(res[0] + ":" + res[1]);
    }

    private int[] calculate(int[] ints, int target) {
        return searchRange(ints, target);
    }

    public int[] searchRange(int[] nums, int target) {
        int lowest = lowerBound(nums, target);
        int[] invalid = new int[]{-1, -1};

        if (lowest < nums.length - 1 && nums[lowest + 1] == target) lowest = lowest + 1;
        else lowest = -1; // if we do not find the element then we can return invalid element directly.
        if (lowest == -1) return invalid;

        int highest = upperBound(nums, target);
        System.out.println("returned:" + highest);
        if (highest > 0 && nums[highest - 1] == target) highest = highest - 1;
        else highest = -1;
        return new int[]{lowest, highest};
    }


    public int upperBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) high = mid - 1;
            else low = mid + 1; // if mid elem is lower to equal move right.
        }
        return low;
    }

    public int lowerBound(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;  // if mid elem is higher or equal move left
        }
        return high;
    }
}
