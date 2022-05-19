package math;

import java.math.BigInteger;

public class FactorialBigInt {
    public static void main(String[] args) {

        BigInteger one = new BigInteger("1");
        BigInteger bigInteger = new BigInteger("1");
        BigInteger multiply = one;

        for (int i = 1; i < 100; i++) {
            multiply = multiply.multiply(bigInteger.add(one));
            bigInteger = bigInteger.add(one);
        }

        System.out.println(multiply);

    }
}
