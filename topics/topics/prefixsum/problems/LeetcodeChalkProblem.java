package prefixsum.problems;

//1894. Find the Student that Will Replace the Chalk 2 sep
public class LeetcodeChalkProblem {
    public static void main(String[] args) {

        LeetcodeChalkProblem lcp = new LeetcodeChalkProblem();
        int[] arr = new int[]{5, 1, 5};
        int k = 22;
        System.out.println("expected 0, got:" + lcp.chalkReplacer(arr, k));

        arr = new int[]{3,4,1,2};
        k = 25;
        System.out.println("expected 1, got:" + lcp.chalkReplacer(arr, k));

    }

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int j : chalk) {
            sum += j;
        }
        k %= sum;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        return -1;
    }

    //todo: to it with binary search.

}
