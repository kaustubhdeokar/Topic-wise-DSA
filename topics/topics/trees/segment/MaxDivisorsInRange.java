package trees.segment;

public class MaxDivisorsInRange {
    public static int[] buildSmallestPrimeArray(int n) {
        int[] smallest_prime = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (smallest_prime[i] == 0) {
                for (int j = i; j <= n; j += i) {
                    if (smallest_prime[j] == 0) {
                        smallest_prime[j] = i;
                    }
                }
            }
        }
        return smallest_prime;
    }

        public static int[] calculateDivisors(int n, int[] smallest_prime) {
            int[] divisors = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int num = i;
                int count = 1;
                while (num > 1) {
                    int prime = smallest_prime[num];
                    int exp = 0;
                    while (num % prime == 0) {
                        num /= prime;
                        exp++;
                    }
                    count *= (exp + 1);
                }
                divisors[i] = count;
            }
            return divisors;
    }
    public static void main(String[] args) {
        int n = 12; // Example size
        MaxDivisorsInRange maxDivisorsInRange = new MaxDivisorsInRange();
        int[] smallest_prime = maxDivisorsInRange.buildSmallestPrimeArray(n);
        int[] divisors = maxDivisorsInRange.calculateDivisors(n, smallest_prime);
//        SegmentTree segmentTree = new SegmentTree(divisors);
//
//        // Example query: maximum number of divisors in range [2, 5]
//        int l = 2, r = 5;
//        int maxDivisors = segmentTree.query(l, r + 1); // r + 1 because the query is inclusive
//        System.out.println("Maximum number of divisors in range [" + l + ", " + r + "] is: " + maxDivisors);
    }

}
