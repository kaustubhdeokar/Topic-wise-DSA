package array.problems;

import java.util.Arrays;

public class ScoresAfterSimulation {
    public static void main(String[] args) {

        int[] nums ={2,1,3,4,5,2};
        ScoresAfterSimulation score = new ScoresAfterSimulation();
        score.findScore(nums);

    }

    public long findScore(int[] nums) {
        long ans = 0;
        int[][] sorted = new int[nums.length][2];
        boolean[] marked = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }

        Arrays.sort(sorted, (a1, a2) -> a1[0] - a2[0]);

        //2.0 1.1 3.2
        //1.1 2.0 3.2

        for (int i = 0; i < nums.length; i++) {
            int number = sorted[i][0];
            int index = sorted[i][1];
            if (!marked[index]) {
                ans += number;
                marked[index] = true;
                // mark adjacent elements if they exist
                if (index - 1 >= 0) {
                    marked[index - 1] = true;
                }
                if (index + 1 < nums.length) {
                    marked[index + 1] = true;
                }
            }
        }

        return ans;
    }
}
