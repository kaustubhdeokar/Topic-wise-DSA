package graph.shortestpath;

import java.util.*;

public class WordLadderII {

    public static void main(String[] args) {
        WordLadderII wordLadderII = new WordLadderII();
        wordLadderII.findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"));
    }

    public void findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        bfs(wordSet, beginWord, endWord);

    }

    private void bfs(Set<String> wordSet, String startWord, String targetWord) {

        Map<String, Integer> mapDistanceToWord = new HashMap<>();
        List<List<String>> paths = new ArrayList<>();
        mapDistanceToWord.put(startWord, 0);
        wordSet.remove(startWord);
        Queue<String> q = new ArrayDeque<>();
        q.add(startWord);

        while (!q.isEmpty()) {

            String word = q.remove();
            if (word.equals(targetWord)) {
                break;
            }

            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                Integer distance = mapDistanceToWord.get(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    builder.setCharAt(i, c);
                    String nextWord = builder.toString();
                    if (wordSet.contains(nextWord)) {
                        mapDistanceToWord.put(nextWord, distance + 1);
                        q.add(nextWord);
                        wordSet.remove(nextWord);
                    }
                }
            }
        }

        System.out.println(mapDistanceToWord);

        //paths
        if(mapDistanceToWord.containsKey(targetWord)){
            ArrayList<String> currRes = new ArrayList<>();
            currRes.add(targetWord);
            dfs(mapDistanceToWord, paths, startWord, targetWord, currRes);
        }

        System.out.println(paths);

    }

    public void dfs(Map<String, Integer> map, List<List<String>> paths, String startWord, String currWord, List<String> currRes) {

        Integer currLevel = map.get(currWord);
        //strings that we can form.

        if (currWord.equals(startWord)) {
            ArrayList<String> path = new ArrayList<>(currRes);
            Collections.reverse(path);
            paths.add(path);
            return;
        }

        for (int i = 0; i < currWord.length(); i++) {

            StringBuilder builder = new StringBuilder(currWord);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                builder.setCharAt(i, ch);
                if(map.containsKey(builder.toString()) && map.get(builder.toString())==currLevel-1)
                {
                    currRes.add(builder.toString());
                    System.out.println();
                    dfs(map, paths, startWord, builder.toString(), currRes);
                    currRes.remove(currRes.size()-1);
                }
            }

        }

    }
}
