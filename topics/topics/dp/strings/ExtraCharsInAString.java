package dp.strings;

import java.util.HashSet;
import java.util.Set;

public class ExtraCharsInAString {

    public static void main(String[] args) {

        String s = "leetcode";
        String[] words = new String[]{"leet","code","leetcode"};

        Set<String> setWords = new HashSet<>();
        for(String word: words){
            setWords.add(word);
        }

        ExtraCharsInAString extra = new ExtraCharsInAString();
        StringBuilder curr = new StringBuilder();
//        extra.findExtraCharsRecursively(s, 0,  curr, setWords);
//todo: check how.
    }

//    private int findExtraCharsRecursively(String s, int i,  StringBuilder curr, Set<String> setWords) {
//        if(i == s.length()) return 0;
//
//        if(setWords.contains(curr.toString())){
//            System.out.println(curr.toString());
//        }
//        else{
//            int result1 = 1 + findExtraCharsRecursively(s, i+1, curr, setWords);
//            int result2 = findExtraCharsRecursively(s, i+1, curr.append(s.charAt(i)), setWords);
//        }
//
//    }

}
