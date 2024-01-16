//https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/
public class FindOriginalFromPrefix {

    public static int[] findArray(int[] pref) {
        // xor has the property of x^y=z, x^z=y
        int[] ans = new int[pref.length];
        ans[0] = pref[0];
        int res = pref[0];
        for (int i = 1; i < pref.length; i++) {
            ans[i] = res ^ pref[i];
            res = res ^ ans[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] pref = { 5, 2, 0, 3, 1 };
        int[] ans = findArray(pref);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

}