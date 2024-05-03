package sliding_window;//https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
import java.util.*;

public class FindAllAnagramsOfPattern {
    public static void main(String[] args) {
        for(Integer i: findAnagramsOfPattern("cbaebabacd", "abc")){
            System.out.println(i);
        }
    }
    public static List<Integer> findAnagramsOfPattern(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        if(s.length()<p.length()){
            return result;
        }

        int[] pChar = new int[26];
        int[] sChar = new int[26];

        int hits = 0;
        for(int i=0;i<p.length();i++){
            pChar[p.charAt(i)-'a']+=1;
            sChar[s.charAt(i)-'a']+=1;
        }
        
        for(int i=0;i<26;i++){
            if(pChar[i]==sChar[i]){
                hits += 1;
            }
        }        
        if(hits == 26){
            result.add(0);
        }
        
        
        int pLen = p.length();
        int sLen = s.length();

        for(int i=pLen; i<sLen; i++){

            int charRemoved = s.charAt(i-pLen)-'a';
            sChar[charRemoved]-=1;
            
            
            int charAdded = s.charAt(i)-'a';
            sChar[charAdded]+=1;
            
            hits = 0;
            for(int j=0;j<26;j++){
                if(pChar[j]==sChar[j]){
                    hits += 1;
                }
            }        
            if(hits == 26){
                result.add(i-pLen+1);
            }
        }
        return result;
    }
}
