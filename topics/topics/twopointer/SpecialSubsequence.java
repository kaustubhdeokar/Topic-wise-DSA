package twopointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SpecialSubsequence {

    public static void main(String[] args) {

        int[] nums = {6, 5, 18, 6, 16, 16, 3, 16};
        int p = 0;
        int q = 2;
        int r = 4;
        int s = 6;

        int n = nums.length;

        Map<Integer, Long> pr = new HashMap<>();
        Map<Integer, Long> qs = new HashMap<>();

        int q1 = 0, r1 = 0, s1 = 0, p1 = 0;
        while (p < n && q < n && r < n && s < n) {

            while (r < n && s < n) {
                for (p1 = p; p1 < q - 1; p1++) {
                    for (r1 = r; r1 < s - 1; r1++) {
                        int val = nums[p1] * nums[r1];
                        pr.merge(val, 1L, Long::sum);
                    }
                }

                for (q1 = q; q1 < r - 1; q1++) {
                    for (s1 = s; s1 < n; s1++) {
                        int val = nums[q1] * nums[s1];
                        qs.merge(val, 1L, Long::sum);
                    }
                }
                r += 1;
                s += 1;
            }
            p = p1 + 1;
            q = q1 + 1;
            r = q + 2;
            s = r + 2;

        }
        System.out.println(pr);
        System.out.println(qs);
        int counts = 0;
        for (Map.Entry<Integer, Long> entry : pr.entrySet()) {
            int key = entry.getKey();
            long val1 = entry.getValue();
            long val2 = qs.containsKey(key) ? qs.get(key) : 0;
            counts += Long.min(val1, val2);
        }
        System.out.println(counts);
    }

}
