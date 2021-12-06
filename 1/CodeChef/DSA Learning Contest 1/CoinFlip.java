import java.util.Scanner;

public class CoinFlip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        while (testCases-- > 0) {
            int games = scan.nextInt();
            while (games-- > 0) {
                int i = scan.nextInt();
                long n = scan.nextLong();
                int q = scan.nextInt();
                if (n % 2 == 0) {
                    System.out.println(n / 2);
                }
                else {
                    if (i != q) {
                        System.out.println((n / 2) + 1);
                    }
                    else {
                        System.out.println(n / 2);
                    }
                }
            }
        }


    }
}
