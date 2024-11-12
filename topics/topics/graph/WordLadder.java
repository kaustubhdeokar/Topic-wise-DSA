package graph;

import java.util.*;

public class WordLadder {

    class StrToDist {
        String str;
        int dist;

        public StrToDist(String str, int dist) {
            this.str = str;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        List<String> wordList = List.of("des", "der", "dfr", "dgt", "dfs");
        String startWord = "der", targetWord = "dfs";
        Set<String> wordSet = new HashSet<>();
        for (String w : wordList) {
            wordSet.add(w);
        }
        WordLadder wordLadder = new WordLadder();
        System.out.println("dist:" + wordLadder.bfs(wordSet, startWord, targetWord));
    }

    private List<List<String>> dfs(Set<String> wordSet, String startWord, String targetWord) {

        List<String> currPath = new ArrayList<>();
        List<List<String>> paths = new ArrayList<>();
        int[] shortestPath = new int[]{Integer.MAX_VALUE};
        dfs(wordSet, startWord, targetWord, currPath, paths, shortestPath);
        return paths.stream().filter(path -> path.size() <= shortestPath[0]).toList();
    }

    private void dfs(Set<String> wordSet, String curr, String targetWord, List<String> currPath, List<List<String>> paths, int[] shortestPath) {


        wordSet.remove(curr);
        currPath.add(curr);

        if (curr.equals(targetWord)) {
            paths.add(new ArrayList<>(currPath));
            shortestPath[0] = Integer.min(shortestPath[0], currPath.size());
//            System.out.println(paths);
            wordSet.add(targetWord);
            return;
        }

        for (int i = 0; i < curr.length(); i++) {
            StringBuilder currPrefix = new StringBuilder(curr.substring(0, i));
            StringBuilder currSuffix = new StringBuilder(curr.substring(i + 1));
            for (int j = 0; j < 26; j++) {
                char currChar = (char) ('a' + j);
                String derivativeString = currPrefix.toString() + currChar + currSuffix.toString();
                if (wordSet.contains(derivativeString)) {
                    dfs(wordSet, derivativeString, targetWord, currPath, paths, shortestPath);
                    currPath.remove(currPath.size() - 1);
                }
            }
        }
        wordSet.add(curr);
    }

    private int bfs(Set<String> wordSet, String startWord, String targetWord) {

        Queue<StrToDist> q = new ArrayDeque<>();
        q.add(new StrToDist(startWord, 0));


        while (!q.isEmpty()) {
            StrToDist strToDist = q.remove();
            String curr = strToDist.str;
            int dist = strToDist.dist;
            if (curr.equals(targetWord)) {
                System.out.println(curr + ":" + dist);
                return dist;
            }

            for (int i = 0; i < curr.length(); i++) {
                char[] word = curr.toCharArray();
                for (int j = 0; j < 26; j++) {
                    char currChar = (char) ('a' + j);
                    word[i] = currChar;
                    String str = String.valueOf(word);
                    if (wordSet.contains(str)) {
                        wordSet.remove(str);
                        System.out.println("adding:" + str);
                        q.add(new StrToDist(str, dist + 1));
                    }
                }
            }
        }
        return 0;
    }
}
