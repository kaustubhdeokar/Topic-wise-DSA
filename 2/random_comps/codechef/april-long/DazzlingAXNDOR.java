import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class DazzlingAXNDOR {

    public static void main(String[] args) throws java.lang.Exception {


        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = scanner.nextInt();
        while (testcases-- > 0) {
            String num = scanner.next();
            BigInteger bigNum = new BigInteger(num);
            BigInteger four = new BigInteger("4");
            BigInteger mod = bigNum.mod(four);

            BigInteger zero = new BigInteger("0");
            BigInteger one = new BigInteger("1");

            if (mod.equals(zero))
                System.out.println(bigNum.add(new BigInteger("3")));

            else if (mod.equals(one))
                System.out.println(bigNum);

            else
                System.out.println(3);
        }

    }


}

