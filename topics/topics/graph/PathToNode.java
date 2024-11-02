package graph;

import java.util.ArrayList;

public class PathToNode {


    public static void main(String[] args) {

        Graph g = new Graph();
        ArrayList<ArrayList<Integer>> graph = g.sampleDirectedGraphPathFinding();
        PathToNode pathToNode = new PathToNode();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> currPath = new ArrayList<>();
        boolean[] visited = new boolean[4];
        pathToNode.findPath(graph, visited, paths, currPath, 0, 3);
    }

    private void findPath(ArrayList<ArrayList<Integer>> graph, boolean[] visited, ArrayList<ArrayList<Integer>> paths,
                          ArrayList<Integer> path, int src, int dest) {

        visited[src] = true;
        path.add(src);
        if (src == dest) {
            paths.add(new ArrayList<>(path));
            System.out.println(paths);
            visited[dest] = false;
            return;
        }
        for (int neigh : graph.get(src)) {
            if (!visited[neigh]) {
                findPath(graph, visited, paths, path, neigh, dest);
                path.remove(path.size() - 1);
            }
        }
        visited[src] = false;


    }


}
