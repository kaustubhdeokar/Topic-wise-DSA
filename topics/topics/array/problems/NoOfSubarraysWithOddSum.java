package array.problems;

public class NoOfSubarraysWithOddSum {

    public static void main(String[] args) {
        NoOfSubarraysWithOddSum noOfSubarraysWithOddSum = new NoOfSubarraysWithOddSum();
        int res = noOfSubarraysWithOddSum.numOfSubarrays(new int[]{1, 3, 5});
        System.out.println("res:" + res);//4 (1,3,5,[1,3,5]
    }

    public int numOfSubarrays(int[] arr) {
        int n = arr.length;

        int count = 0;
        int mod = 1000000007;

        int evenSums = 1; //0
        int oddSums = 0;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum ^ (arr[i] & 1);
            //  System.out.println("sum:"+sum);
            if ((sum & 1) == 1) { //if odd sum then add up the even sum prefixes.
                count = ((count % mod) + (evenSums % mod)) % mod;
                oddSums += 1;
            } else { // vice versa
                count = ((count % mod) + (oddSums % mod)) % mod;
                evenSums += 1;
            }
            // System.out.println("count:"+count+" es:"+evenSums+" os:"+oddSums);
        }

        return count;
    }
}


}
