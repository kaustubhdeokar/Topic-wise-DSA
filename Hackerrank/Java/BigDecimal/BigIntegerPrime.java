import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerPrime {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String n = scan.nextLine();
        BigInteger bg1 = new BigInteger(n);
        if(bg1.isProbablePrime(1)){
            System.out.println("prime");
        }
        else{
            System.out.println("not prime");
        }
        scan.close();

    }
}
