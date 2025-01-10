package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public ArrayList<ArrayList<Integer>> sampleGraph() {

        int[][] graph = new int[][]{{0, 1}, {0, 2}, {1, 2}, {1, 3}, {3, 4}, {2, 4}};
        return createGraph(graph, 5, true);
    }

    public int[][] sampleEulerianCircuitList() {
        return new int[][]{{5, 1}, {4, 5}, {11, 9}, {9, 4}};
    }

    public ArrayList<ArrayList<Integer>> createGraph(int[][] nodes) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int[] node : nodes) {
            int to = node[0];
            int from = node[1];
            while (list.size() < to) {
                list.add(new ArrayList<>());
            }
            list.get(to).add(from);
        }
        return list;
    }

    public ArrayList<ArrayList<Integer>> transitiveClosureGraph() {

        int[][] graph = new int[][]{{0, 1}, {0, 2}, {2, 0}, {1, 2}, {2, 3}};
        return createGraph(graph, 4, false);
    }

    public ArrayList<ArrayList<Integer>> sampleCycleGraph() {
        int[][] graph = new int[][]{{0, 1}, {0, 3}, {1, 2}, {3, 2}, {2, 4}};
        return createGraph(graph, 4, false);
    }

    public ArrayList<ArrayList<Integer>> sampleDirectedGraph() {
        int[][] graph = new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}, {2, 0}};
        return createGraph(graph, 4, false);
    }

    public ArrayList<ArrayList<Integer>> sampleUndirectedGraph() {
        int[][] graph = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {3, 4}};
        return createGraph(graph, 5, true);
    }

    public ArrayList<ArrayList<Integer>> eventualStatesGraph() {
        int[][] graph = new int[][]{
                {0, 1}, {0, 2},
                {1, 2}, {1, 3},
                {2, 5},
                {3, 0},
                {4, 5},
                {},
                {}
        };
        return createGraph(graph, 7, false);
    }

    public ArrayList<ArrayList<Integer>> createKahnsAlgoGraph() {
        int[][] graph = new int[][]{{2, 3}, {3, 1}, {4, 0}, {4, 1}, {5, 0}, {5, 2}};
        return createGraph(graph, 6, false);
    }

    public ArrayList<ArrayList<Integer>> eventualStatesGraph2() {
        int[][] graph = new int[][]{
                {0, 1},
                {1, 2},
                {2, 0},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 3},
                {5, 6},
                {}
        };
        return createGraph(graph, 7, false);
    }

    public ArrayList<ArrayList<Integer>> sampleDirectedGraphPathFinding() {
        int[][] graph = new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {0, 3}
        };
        return createGraph(graph, 4, false);
    }

    public ArrayList<ArrayList<Integer>> createGraph(int[][] graph, int nodes, boolean bidirectional) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] vertex : graph) {
            if (vertex.length == 2) {
                list.get(vertex[0]).add(vertex[1]);
            }
            if (bidirectional) {
                list.get(vertex[1]).add(vertex[0]);
            }
        }
        return list;
    }

    public void createWeightedGraph(ArrayList<ArrayList<int[]>> graph,
                                    int[][] edges, int nodes) {

        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : edges) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.get(from).add(new int[]{to, price});
        }
    }

    public List<List<int[]>> createWeightedGraph(int[][] edges, int nodes) {

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : edges) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.get(from).add(new int[]{to, price});
        }
        return graph;
    }

}
