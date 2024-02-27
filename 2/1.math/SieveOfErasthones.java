public class SieveOfErasthones {

    public static void main(String[] args) {
        findPrimes(50);

    }

    public static void findPrimes(int n) {
        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            for (int j = i*2; j <= n; j += i) {
                arr[j] = true;
            }
        }
        for (int i = 0; i <= 50; i++) {
            if (!arr[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
