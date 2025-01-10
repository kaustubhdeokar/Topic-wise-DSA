package array.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {

    public static void main(String[] args) {

        Problem3 p3 = new Problem3();
        int[][] coins = new int[][]{{8, 10, 1}, {1, 3, 2}, {5, 6, 4}};
        p3.maximumCoins(coins, 4);
    }

    public long maximumCoins(int[][] coins, int k) {

        Map<Integer, Integer> mapEndsWithValues = new HashMap<>();
        int maxR = 0;

        for (int[] coin : coins) {
            int l = coin[0];
            int r = coin[1];
            int v = coin[2];
            mapEndsWithValues.merge(l, v, Integer::sum);
            mapEndsWithValues.merge(r + 1, -1 * v, Integer::sum);
            maxR = Integer.max(maxR, r);
        }

        int e = 0;
        int s = 0;
        long maxScore = 0;
        int lastScore = 0;
        long score = 0;
        while (e < k) {
            if (mapEndsWithValues.get(e) != null) {
                lastScore += mapEndsWithValues.get(e);
            }
            score += lastScore;
            e += 1;

        }

        maxScore = Long.max(maxScore, score);

        int startScore = 0;

        while (e <= (maxR+1)) {
            if (mapEndsWithValues.get(s) != null) {
                startScore += mapEndsWithValues.get(s);
            }
            if (mapEndsWithValues.get(e) != null) {
                lastScore += mapEndsWithValues.get(e);
            }
            score += lastScore;
            score -= startScore;
             maxScore = Long.max(maxScore, score);
            e += 1;
            s += 1;
        }

        return maxScore;

    }
}
