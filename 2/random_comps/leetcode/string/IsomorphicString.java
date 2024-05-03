package string;

import java.util.HashMap;
import java.util.Map;

/*
 Given two strings s and t, determine if they are isomorphic.
 No two characters may map to the same character, but a character may map to itself.
 
 a character can map to a single character.
 so the idea is that map1 will store mapping from s string to t string. 
                     map2 will store mapping from t string to s string. 

 with each s->t mapping, check in map1 & map2 , whether existing mapping exists for the character
 and if the mapping is different than the one found.  
 
 */


public class IsomorphicString {
    
    public static void main(String[] args) {

        IsomorphicString i1 = new IsomorphicString();
        System.out.println("should return false, returns :"+i1.isIsomorphic("baba","badc"));
        System.out.println("should return true, returns :"+i1.isIsomorphic("egg","add"));
        System.out.println("should return true, returns :"+i1.isIsomorphic("paper","title"));
    }

    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for(int i=0;i<s.length();i++){

            if(!map1.containsKey(s.charAt(i)) && !map2.containsKey(t.charAt(i))){
                map1.put(s.charAt(i), t.charAt(i));
                map2.put(t.charAt(i), s.charAt(i));
            }
            else if(map1.containsKey(s.charAt(i))){
                if(map1.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
            else if(map2.containsKey(t.charAt(i))){

                if(map2.get(t.charAt(i))!=s.charAt(i)){
                    return false;
                }
            }
        }
        return true;


    }
}
