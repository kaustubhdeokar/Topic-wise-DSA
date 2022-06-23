package array;

import java.util.HashSet;

public class SubarrayWith0Sum {

    public static void main(String[] args) {

        int[] arr = {9,-6,-48,-48,-44,34,-29,-8,18,-22,39,22,-42,8,48,-14,-42,3};
        findsum(arr);
    }

    static boolean findsum(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i : arr) {
            sum += i;
            if (i==0 || sum == 0 || set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }

}

