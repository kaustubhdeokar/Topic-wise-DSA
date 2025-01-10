package graph;

import java.util.*;

public class AlienDictionary {
    public List<List<Character>> findOrder(String[] dict, int k) {
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

        return charGraph;
    }

    public String topoSort(List<List<Character>> charGraph, int k) {

        boolean[] recStack = new boolean[k];
        boolean[] visited = new boolean[k];
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                if(!dfs(charGraph, i, recStack, visited,  output)){
                    System.out.println("Cycle, return false case answer");
                }
            }
        }
        return output.reverse().toString();
    }

    public boolean dfs(List<List<Character>> graph, int curr, boolean[] recStack, boolean[] visited, StringBuilder tempAns)
    {
        recStack[curr] = true;
        visited[curr] = true;
        for (char n : graph.get(curr)) {
            int neigh = n - 'a';
            if (!visited[neigh]) {
                if(!dfs(graph, neigh, recStack, visited, tempAns)) return false;
            }
            if (recStack[neigh]) {
                return false;
            }
        }
        tempAns.append((char) ('a'+curr));
        recStack[curr] = false;
        return true;
    }

    public static void main(String[] args) {

        String[] list = {"baa","abcd","abca","cab","cad"};
        AlienDictionary alienDictionary = new AlienDictionary();
        List<List<Character>> order = alienDictionary.findOrder(list, list.length);
        System.out.println(order);

        int k = 4;
        String output = alienDictionary.topoSort(order, k);
        System.out.println(output);


    }


}
