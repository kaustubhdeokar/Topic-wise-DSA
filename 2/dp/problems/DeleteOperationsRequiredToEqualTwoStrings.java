package dp;

public class DeleteOperationsRequiredToEqualTwoStrings {

    public int deleteOperationsRequired(String s1, String s2) {

        LCS lcs = new LCS();
        int result = lcs.lcs(s1, s2);
        return s1.length() - result + s2.length() - result;

    }

    public static void main(String[] args) {

        DeleteOperationsRequiredToEqualTwoStrings del = new DeleteOperationsRequiredToEqualTwoStrings();
        System.out.println(del.deleteOperationsRequired("sea", "eat"));// (expected 2)
        //sea -> ea, eat -> ea.
    }

}
