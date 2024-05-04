package stack;

import java.util.Arrays;
import java.util.Stack;

public class CircularGreater {

    public int[] nextGreaterElements(int[] nums) {

        int[] answer = new int[nums.length];
        int numsLength = nums.length;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = -1;
            for (int j = 1; j < nums.length; j++) {
                if (nums[(i + j) % numsLength] > nums[i]) {
                    answer[i] = nums[(i + j) % numsLength];
                    break;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        CircularGreater circularGreater = new CircularGreater();
        int[] ans = circularGreater.nextGreaterElements(new int[]{5, 4, 3, 2, 1});
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

}
