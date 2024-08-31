package graph.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMaxProbability {

    public static void main(String[] args) {

        int[][] graph = {{0, 1}, {1, 2}, {0, 2}};
        int n = 3;
        double[] succProb = new double[]{0.5, 0.5, 0.2};
        int startNode = 0;
        int endNode = 2;
        PathWithMaxProbability path = new PathWithMaxProbability();
        System.out.println(path.traversal(graph, n, succProb, startNode, endNode));

    }

    class NodeToProbability {
        int node;
        double prob;

        public NodeToProbability(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }

        public int getNode() {
            return node;
        }

        public double getProb() {
            return prob;
        }
    }

    private double traversal(int[][] graph, int n, double[] succProb, int startNode, int endNode) {


        ArrayList<ArrayList<NodeToProbability>> probabilityGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            probabilityGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            int to = graph[i][0];
            int from = graph[i][1];
            double prob = succProb[i];
            probabilityGraph.get(to).add(new NodeToProbability(from, prob));
            probabilityGraph.get(from).add(new NodeToProbability(to, prob));
        }

        return findMaximumProbability(probabilityGraph, startNode, endNode, n);

    }

    private double findMaximumProbability(ArrayList<ArrayList<NodeToProbability>> probabilityGraph, int srcNode, int destNode, int nodes) {

        boolean[] visited = new boolean[nodes];
        double[] probability = new double[nodes];
        probability[srcNode] = 1;
        Comparator<NodeToProbability> comp = (c1, c2) -> Double.compare(c2.prob, c1.prob);
        PriorityQueue<NodeToProbability> queue = new PriorityQueue<>(comp);
        queue.add(new NodeToProbability(srcNode, 1));
        visited[srcNode] = true;

        while (!queue.isEmpty()) {
            NodeToProbability top = queue.remove();
            int topNode = top.node;
            double topProb = top.prob;
            for (NodeToProbability neighbour : probabilityGraph.get(topNode)) {
                int neighNode = neighbour.node;
                double probFromTopToNeigh = neighbour.prob;
                if (!visited[neighNode] || probability[neighNode] < topProb * probFromTopToNeigh) {
                    visited[neighNode] = true;
                    if (probability[neighNode] < topProb * probFromTopToNeigh) {
                        probability[neighNode] = topProb * probFromTopToNeigh;
                        queue.add(new NodeToProbability(neighNode, probability[neighNode]));
                    }
                }

            }
        }

        return probability[destNode];

    }


}
