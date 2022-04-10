import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PrimeSM {

    public static void main(String[] args) throws java.lang.Exception {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = scanner.nextInt();
        while (testcases-- > 0) {

            long l1 = scanner.nextLong();
            long l2 = scanner.nextLong();

            if (l1 == 1 || l2 == 1) {
                System.out.println(-1);
            } else if (gcd(l1, l2) == 1) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }
    }

    private static long gcd(long bd1, long bd2) {
        if (bd2 == 0)
            return bd1;
        return gcd(bd2, bd1 % bd2);
    }
}

