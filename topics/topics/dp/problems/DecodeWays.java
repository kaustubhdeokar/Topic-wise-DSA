package dp.problems;
//https://leetcode.com/problems/decode-ways/
public class DecodeWays {

    public int numDecodings(String s) {

        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0' ? 0:1;

        for(int i=1;i<s.length();i++){
            int ans = 0;
            if(s.charAt(i)!='0'){
                ans += dp[i];
            }
            int lastTwo = Integer.parseInt(s.substring(i-1,i+1));
            //System.out.println("lt"+lastTwo);
            if(lastTwo>=10 && lastTwo<=26){ // this is an important case. for example 27 -> output  -> 1 & not 2.
                ans += dp[i-1];
            }
            dp[i+1] = ans;
        }
        // for(int d: dp){
        //     System.out.print(d+" ");
        // }
        return dp[s.length()];

    }
}
