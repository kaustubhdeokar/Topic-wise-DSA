package array.problems;

//question for L1 round service now.
public class RangeSumServiceNow {
    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 7, 9, 6, 8};
        RangeSumServiceNow rs = new RangeSumServiceNow();
        int res = rs.sumOfNumber(arr, 6, 9);
        System.out.println("expected 17, got:" + res);
        arr = new int[]{1, 2, 6, 7, 6, 7, 9};
        res = rs.sumOfNumber(arr, 6, 9);
        System.out.println("expected 16, got:" + res);
        arr = new int[]{6, 9, 6, 9, 6, 9};
        res = rs.sumOfNumber(arr, 6, 9);
        System.out.println("expected 0, got:" + res);
    }

    public int sumOfNumber(int[] arr, int lower, int upper) {

        int sum = 0;
        boolean count = true;
        int alterCount = 0;

        //if lowerFound -> add up to alterCount.
        //if upperFound -> alterCount = 0; count =true
        // 1 2 6 7 9 6 8
        // 1 2 6 7 6 7 9

        for (int i : arr) {

            if (!count && i == lower) {
                sum += alterCount;
                alterCount = 0;
            }

            if (i == lower) {
                count = false;
            }

            if (count) sum += i;
            else alterCount += i;

            if (i == upper) {
                alterCount = 0;
                count = true;
            }
        }
        sum += alterCount;

        return sum;
    }
}

