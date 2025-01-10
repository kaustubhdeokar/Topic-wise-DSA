package binarysearch;

public class NthPowerOfM {
    public static void main(String[] args) {
        int N = 4;
        int M = 69;

        //to find 3rd root of M
        NthPowerOfM pow = new NthPowerOfM();
        System.out.println(pow.find(N, M));
    }

    private int find(int n, int m) {

        if (n == 1) return m;

        int min = 1;
        int max = m;

        while (min <= max) {
            int mid = min + (max - min)/2;
            System.out.println("mid:"+mid);
            int ans = findMthPower(mid, n);
            if(ans == m) return mid;
            else if(ans > m) max = mid - 1;
            else min = mid + 1;
        }
        return -1;
    }

    private int findMthPower(int num, int n) {
        int pow = 1;
        while (n > 0) {
            pow *= num;
            n -= 1;
        }
        return pow;
    }

}
