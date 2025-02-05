package binarysearch;

public class MinMaxmumInSortedArray {
    public static void main(String[] args) {
        MinMaxmumInSortedArray minMax = new MinMaxmumInSortedArray();
        //handle for length = 1 or 2.
        System.out.println(minMax.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(minMax.findMax(new int[]{4, 5, 6, 7, 0, 1, 2}));

        System.out.println(minMax.findMin(new int[]{11, 13, 15, 17}));
        System.out.println(minMax.findMax(new int[]{11, 13, 15, 17}));

        System.out.println(minMax.findMin(new int[]{11, 13, 15, 17, 10}));
        System.out.println(minMax.findMax(new int[]{11, 13, 15, 17, 10}));
    }

    private int findMax(int[] ints) {
        if(ints[0]<ints[ints.length-1]) return ints[ints.length-1];
        int start = 0;
        int end = ints.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int elem = ints[mid];
            int prev = mid==0 ? ints.length-1: mid-1;
            int next = mid==ints.length-1 ? 0:mid+1;
            if (elem > ints[prev] && elem > ints[next]) {
                return elem;
            } else if (elem <= ints[ints.length-1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private int findMin(int[] nums) {
        if(nums[0]<nums[nums.length-1]) return nums[0];
        int start = 0;
        int end = nums.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int elem = nums[mid];
            int prev = mid==0 ? nums.length-1: mid-1;
            int next = mid==nums.length-1 ? 0:mid+1;
            if (elem < nums[prev] && elem < nums[next]) {
                return elem;
            } else if (elem <= nums[nums.length-1]) {
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return -1;

    }
}
