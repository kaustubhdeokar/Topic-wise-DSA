package backtrack;

import java.util.*;

public class ColoringProblem {

    public static void main(String[] args) {

        int[][] edgesArr = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 2}};
        List<int[]> edges = new ArrayList<>(Arrays.asList(edgesArr));
        int vertices = 4;
        ArrayList<ArrayList<Integer>> graph = createGraph(edges, vertices);
        int colorsAllowed = 3;
        ColoringProblem coloringProblem = new ColoringProblem();
        coloringProblem.dfs(graph, vertices, colorsAllowed);

    }

    private boolean dfs(ArrayList<ArrayList<Integer>> graph, int vertices, int colorsAllowed) {

        int[] visited = new int[vertices];
        Arrays.fill(visited, -1);

        for(int i=0;i<vertices;i++){
            if(visited[i]==-1){
                int currNode = i;
                if(!traverse(graph, currNode, visited, colorsAllowed)) return false;

            }
        }
        return true;

    }

    private boolean traverse(ArrayList<ArrayList<Integer>> graph, int currNode, int[] visited, int colorsAllowed) {

        if(!isColoringPossible(graph, currNode, visited, colorsAllowed)) return false;
        //System.out.println("color for "+currNode+" ="+visited[currNode]);
        for(int neighbour: graph.get(currNode)){
            if(visited[neighbour]==-1){
                if(!traverse(graph, neighbour, visited, colorsAllowed)) return false;
            }
        }
        return true;
    }

    private boolean isColoringPossible(ArrayList<ArrayList<Integer>> graph, int currNode, int[] visited, int colorsAllowed) {

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<colorsAllowed;i++) set.add(i);

        for(int neigh: graph.get(currNode)){
            if(visited[neigh]!=-1) set.remove(visited[neigh]);
        }
        if(set.isEmpty()) return false;

        else{
            visited[currNode] = set.iterator().next();
            return true;
        }

    }

    private static ArrayList<ArrayList<Integer>> createGraph(List<int[]> edges, int vertices) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int v = 0; v < vertices; v++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

}
