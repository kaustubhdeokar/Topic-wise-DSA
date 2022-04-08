import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws java.lang.Exception {


        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = scanner.nextInt();
        while (testcases-- > 0) {
            long i = scanner.nextLong();
            long j = scanner.nextLong();
            if (!verifyRange(i, j)) {
                System.out.println(-1);
            }
            else {
                if ((i % 2) == 0)//even
                {
                    System.out.println(i + " " + (i + 2));
                } else {//i is odd . 9
                    long gcd = calculateGcd(i, i+3);//9,10,11,12
                    if (gcd > 1)
                        System.out.println(i + " " + (i + 3));
                    else
                        System.out.println((i + 1) + " " + (i + 3));
                }
            }

        }

    }

    public static long calculateGcd(long a, long b) {
        if (b == 0)
            return a;
        return calculateGcd(b, a % b);
    }

    public static boolean verifyRange(long start, long end) {
        if ((start % 2) == 0)//even
            return (end - start) >= 2;
        else
            return (end - start) >= 3;
    }



}

