package LongestConsecutiveSeq;

public class LCSByRangeCalculation {

    public int[] calculateMinElemAndRange(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : nums) {
            min = Integer.min(min, i);
            max = Integer.max(max, i);
        }
        return new int[]{min, max - min + 1};
    }

    public int longestConsecutive(int[] nums) {

        int[] minAndRange = calculateMinElemAndRange(nums);
        int min = minAndRange[0];
        int range = minAndRange[1];

        //for ex:nums is  5 6 12 13 14
        //so arr with be of len (14-5+1)
        //first index counts occurrence for 5.
        int[] arr = new int[range];
        for (int num : nums) {
            arr[num - min] += 1;
        }

        int maxCount = 0;
        int count = 0;
        for (int i : arr) {
            if (i > 0) {
                count += 1;
                maxCount = Integer.max(maxCount, count);
            }
            else {
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 4, 8, 5, 6, 7, 9, 3, 55, 88, 77, 99, 999999999};
        LCSByRangeCalculation lcs = new LCSByRangeCalculation();
        int count = lcs.longestConsecutive(arr);
        //lots of memory being used unnecessarily.
        System.out.println(count);

    }
}
