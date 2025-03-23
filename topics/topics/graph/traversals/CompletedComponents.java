package graph.traversals;

import java.util.ArrayList;
import java.util.List;

public class CompletedComponents {

    public int countCompleteComponents(int n, int[][] edges) {

        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        for(int[] edge: edges)
        {
            int to = edge[0];
            int from = edge[1];
            graph.get(to).add(from);
            graph.get(from).add(to);
        }

        int completeComps = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                int[] nodesInCurrComp = {0};
                List<Integer> currTraversal = new ArrayList<>();
                traverse(graph, i, visited, nodesInCurrComp, currTraversal);
                if(calculateIfCompleteComponent(currTraversal, graph, nodesInCurrComp[0]-1)){
                    completeComps += 1;
                }
            }
        }
        return completeComps;
    }

    public boolean calculateIfCompleteComponent(List<Integer> currTrav, List<List<Integer>> graph, int expected){
        for(int node: currTrav){
            if(graph.get(node).size()!=expected) return false;
        }
        return true;
    }

    public void traverse(List<List<Integer>> graph, int curr, boolean[] visited, int[] nodes, List<Integer> currTraversal)
    {
        visited[curr] = true;
        nodes[0]+=1;
        currTraversal.add(curr);

        for(int adj:graph.get(curr)){
            if(!visited[adj]){
                traverse(graph, adj, visited, nodes, currTraversal);
            }
        }
    }

    public static void main(String[] args) {

    }
}
