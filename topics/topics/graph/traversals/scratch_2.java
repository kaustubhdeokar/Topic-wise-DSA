import graph.Graph;
import graph.traversals.EventualSafeStates;

import java.util.ArrayList;

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

        for(int i=0;i<nodes;i++){
            System.out.println(directedGraph.get(i));
        }

    }

}