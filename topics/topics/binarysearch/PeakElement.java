package binarysearch;

public class PeakElement {
    public int findPeakElement(int[] nums) {
        //m > l && m > h -> answer -> return idx.
        //m > l && m < h -> ascending -> move right.
        //m < l && m > h -> descending -> move left.
        //m < l && m < h -> can do both -> chosing right for now.

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean greaterThanLeft = mid == 0 ? true : nums[mid] > nums[mid - 1];
            boolean greaterThanRight = mid == nums.length - 1 ? true : nums[mid] > nums[mid + 1];

            if (greaterThanLeft && greaterThanRight) {
                return mid;
            }

            if (greaterThanLeft && !greaterThanRight) {
                low = mid + 1;
            }
            // else if(!greaterThanLeft && greaterThanRight){
            else {
                high = mid - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {

        PeakElement peakElement = new PeakElement();
        peakElement.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
    }
}
