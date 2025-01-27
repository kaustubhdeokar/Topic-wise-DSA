package recursion;

import java.util.*;

public class WordBreakII {

    public static void main(String[] args) {

        WordBreakII wordBreakII = new WordBreakII();
        List<String> res = wordBreakII.wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog"));
        System.out.println(res);

    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        //catsanddog - cat found
        //sanddog - sand found
        //dog - found
        //end reached -> form sentence.

        //cats and dog -

        int start = 0;
        int end = s.length()-1;
        Map<List<Integer>, Boolean> map = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> temp = new ArrayList<>();
        List<String> result = new ArrayList<>();
        wordBreak(s, start, end, wordSet, map, temp, result);

        return result;
    }

    public boolean wordBreak(String s, int start, int end, Set<String> wordSet, Map<List<Integer>, Boolean> map, List<String> temp, List<String> result){
        if(start>end) {
            System.out.println(temp);
            String res = String.join(" ", temp);
            result.add(res);
            return true;
        }

        StringBuilder curr = new StringBuilder();
        for(int i=start;i<=end;i++){
            curr.append(s.charAt(i));
            if(wordSet.contains(curr.toString())){
                temp.add(curr.toString());
                boolean res = wordBreak(s, i+1, end, wordSet, map, temp, result);
                temp.remove(temp.size()-1);
            }
        }
        return false;

    }

}
