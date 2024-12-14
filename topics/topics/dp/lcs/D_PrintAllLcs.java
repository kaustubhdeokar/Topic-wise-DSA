package dp.lcs;

import java.util.ArrayList;
import java.util.List;

public class D_PrintAllLcs {
    static int MAX = 55;
    static int lcslen = 0;

    // DP array and list to store answers
    static int[][] dp = new int[MAX][MAX];
    static List<String> ans;

    // Function to find LCS length
    static int lcs(String str1, String str2, int len1, int len2, int i, int j) {
        int ret = dp[i][j];

        // Base condition
        if (i == len1 || j == len2) return ret = 0;

        if (ret != -1) return ret;
        ret = 0;

        if (str1.charAt(i) == str2.charAt(j))
            ret = 1 + lcs(str1, str2, len1, len2, i + 1, j + 1);
        else
            ret = Math.max(lcs(str1, str2, len1, len2, i + 1, j),
                    lcs(str1, str2, len1, len2, i, j + 1));

        return dp[i][j] = ret;
    }

    // Function to print all LCS
    static void printAll(String str1, String str2, int len1, int len2, char[] data,
                         int indx1, int indx2, int currlcs) {

        if (currlcs == lcslen) {
            data[currlcs] = '\0';
            ans.add(new String(data));
            return;
        }

        if (indx1 == len1 || indx2 == len2) return;

        for (char ch = 'a'; ch <= 'z'; ch++) {

            boolean done = false;

            for (int i = indx1; i < len1; i++) {

                if (ch == str1.charAt(i)) {
                    for (int j = indx2; j < len2; j++) {

                        if (ch == str2.charAt(j) && dp[i][j] == lcslen - currlcs) {
                            data[currlcs] = ch;
                            printAll(str1, str2, len1, len2, data, i + 1, j + 1,
                                    currlcs + 1);
                            done = true;
                            break;
                        }
                    }
                }

                if (done) break;
            }
        }
    }

    // Main function to find all LCS
    public List<String> all_longest_common_subsequences(String str1, String str2) {

        ans = new ArrayList<>();
        int len1 = str1.length(), len2 = str2.length();

        // Initialize DP array
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                dp[i][j] = -1;
            }
        }

        // Find LCS length and print all LCS
        lcslen = lcs(str1, str2, len1, len2, 0, 0);
        char[] data = new char[MAX];
        printAll(str1, str2, len1, len2, data, 0, 0, 0);
        return ans;
    }

    static void lcs(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }

        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }

        int len=dp[n][m];
        int i=n;
        int j=m;

        int index = len-1;
        String str="";
        for(int k=1; k<=len;k++){
            str +="$"; // dummy string
        }
        StringBuilder ss= new StringBuilder(s1);
        StringBuilder str2=new StringBuilder(str);
        while(i>0 && j>0){
            if(ss.charAt(i-1) == s2.charAt(j-1)){
                str2.setCharAt(index,ss.charAt(i-1) );
                index--;
                i--;
                j--;
            }
            else if(ss.charAt(i-1)>s2.charAt(j-1)){
                i--;
            }
            else j--;
        }
        System.out.println(str2);
    }


    public static void main(String[] args) {
        D_PrintAllLcs printAllLcs = new D_PrintAllLcs();
        List<String> strings = printAllLcs.all_longest_common_subsequences("hfofxe", "hfxeof");
        for(String s: strings){
            System.out.println(s.trim());
        }

    }
}