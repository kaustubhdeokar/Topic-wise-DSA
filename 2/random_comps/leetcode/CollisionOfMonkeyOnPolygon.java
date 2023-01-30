import java.math.BigInteger;

class CollisionOfMonkeyOnPolygon {
    public int monkeyMove(int n) {

        BigInteger mod = BigInteger.valueOf((long) Math.pow(10, 9) + 7);
        BigInteger num = BigInteger.valueOf(n);

        int ans = BigInteger.valueOf(2).modPow(num, mod).intValue() - 2;
        ans = BigInteger.valueOf(ans).mod(mod).intValue();
        return ans;
    }
    
}


/*

python has a damn easy solution for calculating modulo of larger nums.

pow(2, 500000003, mod) + mod - 2

*/
