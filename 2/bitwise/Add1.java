public class Add1 {

    public static void main(String[] args) {

        int n = 13;
        System.out.println(addOne(n));
    }

    public static int addOne(int n) {
        // to add 1, flip bits till encountering a zero.
        int m = 1;
        while ((m & n) == 1) {
            n^=m;
            m<<=1;
            System.out.println("n:"+n);
        }
        System.out.println("m:"+m);
        n^=m;
        return n;
    }

    public static int flipBits(int n) {
        int m = 1;
        while (m <= n) {
            n ^= m;
            m <<= 1;
        }
        return n;
    }

}
