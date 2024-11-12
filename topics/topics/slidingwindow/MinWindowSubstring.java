package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static void main(String[] args) {
        MinWindowSubstring mws = new MinWindowSubstring();
        String ans = mws.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(ans);
    }

    public String minWindow(String s, String t) {

        if(t.length()>s.length()) return "";
        if(t.equals(s)) return s;

        Map<Character, Integer> targetMap = new HashMap<>();
        fillInput(targetMap, t);
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;
        int count = t.length(); // 3 (ABC)

        while(right< s.length())
        {
            char curr = s.charAt(right++);
            if(targetMap.containsKey(curr))
            {
                //we make encounter extra characters, only take the needful ones.
                //ABC -> if we get AABC
                //count goes from A1B1C1 to A-1B0C0, here we should count the extra A.

                if(targetMap.get(curr)>0) count-=1;
                targetMap.put(curr, targetMap.get(curr)-1);
            }

            while(count==0)
            {
                curr = s.charAt(left);
                if((right-left)<=minLength){
                    minLength = right-left;
                    minLeft = left;
                }

                if(targetMap.get(curr)!=null)
                {
                    targetMap.put(curr, targetMap.get(curr)+1);
                    if(targetMap.get(curr)>0) count+=1;
                }

                left+=1;
            }


        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }

    public void fillInput(Map<Character, Integer> map, String t){
        for(int i=0;i<t.length();i++){
            char curr = t.charAt(i);
            map.put(curr, map.getOrDefault(curr,0)+1);
        }
    }

}
