//Given two integers A and M, find the modular multiplicative inverse of A under modulo M.
//The modular multiplicative inverse is an integer X such that:
// X*A%M=1
//The value of X should be in the range {1, 2, … M-1},
// modular inverse exists only if a and m are relatively prime. (gcd(a,m)=1)


// (a%c) / (b%c) = ((a%c) * (b^-1)%c)%c

public class ModularInverse {

    public static void main(String[] args) {

        int a = 4;
        int m = 5;

        //System.out.println(simpleIterativeMethod(a, m));

        int[] gcd = {0};
        int[] coeff = {0, 0};

        CoefficientInGcd coefficientInGcd = new CoefficientInGcd();
        System.out.println(coefficientInGcd.findCoefficients(a, m, gcd, coeff));

        //findUsingFermatsTheorem(a, m);
    }

    private static void findUsingFermatsTheorem(int a, int m) {
        ModularExpo modularExpo = new ModularExpo();
        //a^(m-1) = 1 mod m
        //a^(m-2) mod m = a^(m-1) mod m.
        System.out.println(modularExpo.exponential(a, m -2, m));
    }


    private static int simpleIterativeMethod(int a, int m) {
        for (int i = 1; i < m; i++) {
            if (((a % m) * (i % m)) % m == 1) {
                return i;
            }
        }
        return -1;
    }


}
