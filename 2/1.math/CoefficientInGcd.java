
//    Extended euclidean algorithm.
//    Ax + By = gcd(a,b)
//    To find x and y which satisfies the eqn.
//    page 1: https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/tutorial/

public class CoefficientInGcd {

    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        int[] gcd = {0};
        int[] coeff = {0, 0};
        CoefficientInGcd coefficientInGcd = new CoefficientInGcd();
        System.out.println(coefficientInGcd.findCoefficients(a, b, gcd, coeff));
    }

    public int findCoefficients(int a, int b, int[] gcd, int[] coeff) {
        if (b == 0) {
            //gcd found.
            gcd[0] = a;
            coeff[0] = 1;
            coeff[1] = 0;
        } else {
            findCoefficients(b, a % b, gcd, coeff);
            int temp = coeff[0];
            coeff[0] = coeff[1];
            coeff[1] = temp - (a / b) * coeff[1];
            System.out.println("a:" + a + " b:" + b + " x:" + coeff[0] + " y:" + coeff[1]);
        }
        return coeff[0];
    }

}
