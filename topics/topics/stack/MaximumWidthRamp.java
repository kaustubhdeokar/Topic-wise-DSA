package stack;

import java.util.Stack;

public class MaximumWidthRamp {

    public static void main(String[] args) {

        MaximumWidthRamp maximumWidthRamp = new MaximumWidthRamp();
        int[] nums = new int[]{6,0,8,2,1,5};
        System.out.println(maximumWidthRamp.maxWidthRamp(nums));

    }

    class MapValToIdx {
        int val;
        int idx;

        MapValToIdx(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int maxWidthRamp(int[] nums) {


        Stack<MapValToIdx> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new MapValToIdx(nums[i], i));
            } else if (stack.peek().val > nums[i]) {
                stack.push(new MapValToIdx(nums[i], i));
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek().val) {
                result = Integer.max(result, i - stack.peek().idx);
                stack.pop();
            }
        }

        return result;
    }

}
