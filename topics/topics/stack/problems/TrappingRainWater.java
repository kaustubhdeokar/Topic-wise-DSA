package stack.problems;

public class TrappingRainWater {

    public int trap(int[] height) {
        int[] leftMaxArr = new int[height.length];
        int[] rightMaxArr = new int[height.length];

        int len = height.length;

        int leftMax = height[0];
        for (int i = 0; i < height.length; i++) {
            leftMax = Integer.max(leftMax, height[i]);
            leftMaxArr[i] = leftMax;


        }

        int rightMax = height[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            rightMax = Integer.max(rightMax, height[i]);
            rightMaxArr[i] = rightMax;
        }

        int total = 0;
        for (int i = 0; i < len; i++) {
            total += Integer.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }
        return total;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int ans = trappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(ans);
    }
}
