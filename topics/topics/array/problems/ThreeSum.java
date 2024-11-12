package array.problems;

import java.util.*;

public class ThreeSum {
    private List<List<Integer>> res;

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum.threeSum(arr));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        int l, r, sum;
        Set<List<Integer>> tempRes = new HashSet<>();
        for (int i = 0; i < nums.length - 2; ++i)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            l = i + 1;
            r = nums.length - 1;
            while(l<r){
                sum = nums[i]+nums[l]+nums[r];
                if(sum==0) tempRes.add(List.of(nums[i], nums[l], nums[r]));
                if(sum>0) r--;
                else ++l;
            }
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>(tempRes);
        return res;
    }
}
