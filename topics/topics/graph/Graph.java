package graph;

import java.util.ArrayList;

public class Graph {

    public ArrayList<ArrayList<Integer>> sampleGraph() {

        int[][] graph = new int[][]{{0, 1}, {0, 2}, {1, 2}, {1, 3}, {3, 4}, {2, 4}};
        return createGraph(graph, 5, true);
    }

    private ArrayList<ArrayList<Integer>> createGraph(int[][] graph, int nodes, boolean bidirectional) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            list.add(new ArrayList<>());
        }
        for(int[] vertex: graph){
            list.get(vertex[0]).add(vertex[1]);
            if(bidirectional) {
                list.get(vertex[1]).add(vertex[0]);
            }
        }
        return list;
    }

}
