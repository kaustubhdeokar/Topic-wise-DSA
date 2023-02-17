import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {

            if (map.get(target - nums[i]) != null) {

                int pos1 = map.get(target - nums[i]);
                return new int[]{pos1, i};

            }

            map.put(nums[i], i);

        }

        return new int[]{};

    }


}
	
		
