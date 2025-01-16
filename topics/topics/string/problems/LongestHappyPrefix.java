package string.problems;

//https://leetcode.com/problems/longest-happy-prefix/description/?envType=problem-list-v2&envId=string-matching
public class LongestHappyPrefix {

    public String longestPrefix(String s) {

        int[] lps = new int[s.length()];
        int i = 0;
        int j = 1;
        lps[i] = 0;

        while(j<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                lps[j] = i+1;
                i+=1;
                j+=1;
            }
            else{
                if(i==0){
                    lps[j] = 0;
                    j+=1;
                }
                else{
                    i = lps[i-1];
                }
            }
        }

        return s.substring(0, lps[s.length()-1]);
    }

    public static void main(String[] args) {
        LongestHappyPrefix longestHappyPrefix = new LongestHappyPrefix();
        String res;
        res = longestHappyPrefix.longestPrefix("ababab");
        System.out.println("res:"+res);
        res = longestHappyPrefix.longestPrefix("bba");
        System.out.println("res:"+res);
    }
}
