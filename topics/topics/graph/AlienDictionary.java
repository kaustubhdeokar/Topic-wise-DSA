package graph;

import java.util.*;

public class AlienDictionary {
    public String findOrder(String[] dict, int n, int k) {
        //create a graph.
        // compare two adjacent words for alien sorting order.
        //{ {--},{---},{--}} // for a b and c respectively.

        //topological sort.

        List<List<Character>> charGraph = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            charGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < dict.length - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];

            int c1 = 0;
            int c2 = 0;
            while (c1 < word1.length() && c2 < word2.length() &&
                    word1.charAt(c1) == word2.charAt(c2)) {
                c1 += 1;
                c2 += 1;
            }
            if (c1 < word1.length() && c2 < word2.length()) {
                int to = (int) word1.charAt(c1) - 'a';
                charGraph.get(to).add(word2.charAt(c2));
            }
        }

        boolean[] recStack = new boolean[k];
        boolean[] visited = new boolean[k];
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                if (dfs(charGraph, i, recStack, visited, output)) {
                    return "";
                }
            }
        }
        output = output.reverse();
        return output.toString();
    }

    public boolean dfs(List<List<Character>> graph, int curr, boolean[] recStack, boolean[] visited, StringBuilder res) {

        recStack[curr] = true;
        visited[curr] = true;
        for (char n : graph.get(curr)) {
            int neigh = n - 'a';
            if (!visited[neigh]) {
                if (dfs(graph, neigh, recStack, visited, res)) {
                    return true;
                }
            }
            if (recStack[neigh]) {
                return true;
            }
        }
        res.append((char) ('a' + curr));
        recStack[curr] = false;

        return false;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(1);
        int[][] factory = new int[][]{{2, 2}, {6, 2}, {-2, 2}};
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] locCap : factory) {
            map.put(locCap[0], locCap[1]);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> curr = iterator.next();
            int currVal = curr.getValue();

        }


    }


}
