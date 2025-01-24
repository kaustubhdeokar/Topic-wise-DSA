package graph.traversals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class EventualSafeWithBfs {
    public static void main(String[] args) {

        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        int[] outDegree = new int[graph.length];


        // using a topological sort - we start by calculating the indegree.
        // in this case - nodes which are safe are those who have no outdegree - end nodes.
        // so we trace back from the end nodes to the nodes which do not have a cycle.
        // if the outdegree is 0 for any intermediary node, it means that we can reach the end node safely.
        // for those nodes who are a part of cycle, the outdegree will never be 0.

        List<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            reverseGraph.add(new ArrayList<>());
        }

        for(int i=0;i<graph.length;i++){
            for(int neighbours: graph[i]){
                reverseGraph.get(neighbours).add(i);
                outDegree[i]+=1;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int n = 0; n < outDegree.length; n++) {
            if (outDegree[n] == 0) {
                queue.add(n);
            }
        }

        boolean[] processingDone = new boolean[graph.length];
        while (!queue.isEmpty()) {
            Integer top = queue.remove();
            processingDone[top] = true;
            for (int neighbour : reverseGraph.get(top)) {
                outDegree[neighbour] -= 1;
                if (outDegree[neighbour] == 0) queue.add(neighbour);
            }
        }

        for (int i = 0; i < processingDone.length; i++) {
            if (processingDone[i]) {
                System.out.print(i + " ");
            }
        }

    }
}
