package array.problems;

import java.util.HashMap;
import java.util.Map;

public class ArraysPairs {

    public static void main(String[] args) {

        ArraysPairs arraysPairs = new ArraysPairs();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 5;
        System.out.println(arraysPairs.canArrange(arr, k));

    }

    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            int key = ((i % k) + k) % k;
            if (map.get(key) != null) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if (key == 0 || key == (k - key)) {
                if (map.get(key) % 2 != 0) {
                    return false;
                }
            } else if (map.get(key) != map.get(k - key)) {
                return false;
            }
            System.out.println(map.get(key));
        }
        return true;
    }

}
