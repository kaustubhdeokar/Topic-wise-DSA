public class CheckBitSet {

    public static void main(String[] args) {
        CheckBitSet checkBitSet = new CheckBitSet();
        // System.out.println(checkBitSet.kthBitSet(3, 2));
        // checkBitSet.checkSetBits(8);
        checkBitSet.checkNegate(3);

    }

    public boolean kthBitSet(int n, int k) {
        return (n & (1 << k)) != 0;
    }

    public boolean checkSetBits(int n) {
        // check no of digits.
        int k = 1;
        while(k<=n){
            System.out.println(n&k);
            k*=2;
        }
        return false;
    }

    public void checkNegate(int n){
        System.out.println(n^(~n));
    }

    
}
