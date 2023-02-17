import java.util.ArrayList;

public class MinimumCostToMakeArraysEqual{


    public static void main(String[] args) {

        int[] nums = {758, 334, 402, 1792, 1112, 1436, 1534, 1702, 1538, 1427, 720, 1424, 114, 1604, 564, 120, 578};
        int[] target = {1670, 216, 1392, 1828, 1104, 464, 678, 1134, 644, 1178, 1150, 1608, 1799, 1156, 244, 2, 892};

        MinimumCostToMakeArraysEqual i = new MinimumCostToMakeArraysEqual();
        System.out.println(i.operationsToMakeEqual(nums, target));


    }

    public long operationsToMakeEqual(int[] nums, int[] target) {

        ArrayList<Integer> oddTarget = new ArrayList<>();
        ArrayList<Integer> oddNums = new ArrayList<>();
        ArrayList<Integer> evenTarget = new ArrayList<>();
        ArrayList<Integer> evenNums = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenNums.add(nums[i]);
            } else {
                oddNums.add(nums[i]);
            }

            if (target[i] % 2 == 0) {
                evenTarget.add(target[i]);
            } else {
                oddTarget.add(target[i]);
            }
        }

        oddNums.sort(Integer::compare);
        evenNums.sort(Integer::compare);
        oddTarget.sort(Integer::compare);
        evenTarget.sort(Integer::compare);

        long maxOperations = 0;

        for (int i = 0; i < evenNums.size(); i++) {
            maxOperations += Math.abs(evenTarget.get(i) - evenNums.get(i)) / 2;
        }
        for (int i = 0; i < oddNums.size(); i++) {
            maxOperations += Math.abs(oddTarget.get(i) - oddNums.get(i)) / 2;
        }

        return maxOperations / 2;

    }

}

