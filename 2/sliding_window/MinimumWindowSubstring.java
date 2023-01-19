import java.util.*;

public class MinimumWindowSubstring {
    
    public String minWindow(String s, String t) {
        
        String minString = "";
        if(s.length()<t.length()){
            return minString;
        }

        int start = 0;
        int end = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        //1
        //adobec (a=0b=0c=0) as we encounter them via end counter, we will reduce by 1. 
        //as it reaches 0, increment hits by 1.
        //hits == tMap.size(), count string length & calculate min string.
        //2
        //add them back, from start counter. increment by 1

        for(int i=0;i<t.length();i++){
            char currChar = t.charAt(i);
            insertIntoMap(sMap, currChar);
            insertIntoMap(tMap, currChar);
        }

        int hits = 0;
        int hitsNeeded = tMap.size();
        int minLen = Integer.MAX_VALUE;
        
        while(start < s.length() && end <= s.length()){

            if(hits < hitsNeeded && end < s.length()){
                char currChar = s.charAt(end);
               // System.out.println("end, currChar:"+currChar);
                if(sMap.containsKey(currChar)){
                    sMap.put(currChar, sMap.get(currChar)-1);
                    if(sMap.get(currChar)==0){
                     //   System.out.println("end, hit for currChar:"+currChar);
                        hits += 1;
                    }
                }
                
                end += 1;
            }
            else if(hits == hitsNeeded || (end == s.length() && start < s.length())){
                
                if( hits == hitsNeeded && minLen > (end - start)){
                    minLen = end-start;
                    minString = s.substring(start, end);
                  //  System.out.println("minString:"+minString);
                }

                char currChar = s.charAt(start);
               // System.out.println("start, currChar:"+currChar);
                if(sMap.containsKey(currChar)){
                    sMap.put(currChar, sMap.get(currChar)+1);
                    if(sMap.get(currChar)==1){
                    //    System.out.println("hit restored, currChar:"+currChar);
                        hits -= 1;
                    }   
                }
                
                start += 1;
            }
            else if(hits > hitsNeeded){
                System.out.println("wtf is this.");
            }

           // System.out.println("start:"+start+" end:"+end);
        }

        return  minString;

    }

    public void insertIntoMap(HashMap<Character, Integer> map, char currChar){

        if(map.containsKey(currChar)){
            map.put(currChar, map.get(currChar)+1);
        }
        else{
            map.put(currChar, 1);
        }

    }

}
