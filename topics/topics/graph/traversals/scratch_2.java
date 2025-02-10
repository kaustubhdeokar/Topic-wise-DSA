package graph.traversals;

import graph.Graph;
import graph.traversals.EventualSafeStates;

import java.util.ArrayList;
import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {

        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> directedGraph = g.eventualStatesGraph2();
        int nodes = directedGraph.size();
        EventualSafeStates eventualSafeStates = new EventualSafeStates();
        Scratch s = new Scratch();
        s.traverse(directedGraph, nodes);
    }

    private void traverse(ArrayList<ArrayList<Integer>> directedGraph, int nodes) {
        boolean[] visited = new boolean[nodes];
        boolean[] recstack = new boolean[nodes];
        boolean[] safeNodes = new boolean[nodes];
        Arrays.fill(safeNodes, true);

        for (int i = 0; i < nodes; i++) {

            if (!visited[i]) {
                if (traverse(i, directedGraph, visited, recstack)) {
                    System.out.println("cycle");
                    for (int j = 0; j < recstack.length; j++) {
                        if(recstack[j]) {
                            System.out.println("unsafe:" + j);
                            safeNodes[j] = false;
                        }
                    }

                }
            }
        }

    }

    private boolean traverse(int i, ArrayList<ArrayList<Integer>> directedGraph, boolean[] visited, boolean[] recstack) {

        visited[i] = true;
        recstack[i] = true;

        for (int neigh : directedGraph.get(i)) {
            if (!visited[neigh]) {
                if (traverse(neigh, directedGraph, visited, recstack)) return true;
            } else if (recstack[neigh]) {
                return true;
            }
        }
        recstack[i] = false;
        return false;
    }

}