package graph.traversals;

import graph.Graph;

import java.util.ArrayList;
import java.util.List;

//** got stuck -> there can be no cycles, so in that case, the eventual states should be a list of all nodes, here the recStack will be empty.
//** got stuck -> there can be multiple cycles, as soon as one cycle is fine, do not return the recStack, keeping iterating over the unvisited nodes.
public class EventualSafeStates {

    public static void main(String[] args) {

        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> directedGraph;
        EventualSafeStates eventualSafeStates = new EventualSafeStates();
        List<Integer> result = new ArrayList<>();

//        ArrayList<ArrayList<Integer>> directedGraph = g.eventualStatesGraph();
//        EventualSafeStates eventualSafeStates = new EventualSafeStates();
//        List<Integer> result = eventualSafeStates.eventualSafeNodes(directedGraph);
//        System.out.println(result);

        directedGraph = g.eventualStatesGraph2();
        result = eventualSafeStates.eventualSafeNodes(directedGraph);
        System.out.println(result);

    }

    List<Integer> eventualSafeNodes(ArrayList<ArrayList<Integer>> adj) {
        return calculate(adj, adj.size());
    }

    private List<Integer> calculate(ArrayList<ArrayList<Integer>> graph, int nodes)
    {
        boolean[] visited = new boolean[nodes];
        boolean[] recStack = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                traverse(graph, i, visited, recStack, nodes);
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0;i<recStack.length;i++){
            if(!recStack[i]) res.add(i);
        }
        return res;

    }

    private boolean traverse(ArrayList<ArrayList<Integer>> graph, int curr, boolean[] visited, boolean[] recStack, int nodes) {
        visited[curr] = true;
        recStack[curr] = true;

        for (int adj : graph.get(curr)) {
            if (!visited[adj]) {
                if (traverse(graph, adj, visited, recStack, nodes)) {
                    return true;
                }
            }
            if (recStack[adj]) {
                return true;
            }
        }
        recStack[curr] = false;
        return false;
    }


}
