package recursion;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        boolean res = wordBreak.wordBreak("leetcode", List.of("leet", "code"));
        System.out.println(res);
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        Map<List<Integer>, Boolean> map = new HashMap<>();
        return wordBreak(s, 0, s.length() - 1, set, map);
    }

    public boolean wordBreak(String s, int start, int end, Set<String> set, Map<List<Integer>, Boolean> map)
    {
        if(start>end) return true;
        if(map.get(List.of(start, end))!=null) return map.get(List.of(start, end));

        StringBuilder curr = new StringBuilder();
        for (int i = start; i <= end; i++) {
            curr.append(s.charAt(i));
            if (set.contains(curr.toString())) {
                boolean res = wordBreak(s, i + 1, end, set, map);
                if (res) {
                    map.put(List.of(start, end), true);
                    return true;
                }
                else{
                    map.put(List.of(start,end), false);
                }
            }
        }
        map.put(List.of(start, end), false);
        return false;
    }
}
