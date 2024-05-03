///Given three numbers x, y and p, compute (x^y) % p.
public class ModularExpo {
    public static void main(String[] args) {

        System.out.println("expected 4, got: " + new ModularExpo().exponential(2, 10, 10));
    }

    /**
     * This method is called as binary exponentiation.
     */
    public int exponential(int number, int power, int mod) {

        // 2^10      oddPowMultiplier=1    evenPowMultiplier=2   p=10
        // (4)^5     oddPowMultiplier=1    evenPowMultiplier=4   p=5
        // 4*(4^4)   oddPowMultiplier=4    evenPowMultiplier=4   p=4
        // 4*(16^2)  oddPowMultiplier=4    evenPowMultiplier=16  p=2
        // 4*(256^1) oddPowMultiplier=4    evenPowMultiplier=256 p=1
        // 4*256     oddPowMultiplier=1024 evenPowMultiplier=256 p=0

        int evenPowMultiplier = number;
        int oddPowMultiplier = 1;

        while (power > 0) {
            if (power % 2 == 0) {
                evenPowMultiplier *= evenPowMultiplier;
                evenPowMultiplier %= mod;
                power /= 2;
            } else {
                oddPowMultiplier *= evenPowMultiplier;
                oddPowMultiplier %= mod;
                power -= 1;
            }
            System.out.print("power:" + power + " oddPowMultiplier:" + oddPowMultiplier);
            System.out.println(" evenPowMultiplier:" + evenPowMultiplier);

        }
        return oddPowMultiplier % mod;
    }

}
