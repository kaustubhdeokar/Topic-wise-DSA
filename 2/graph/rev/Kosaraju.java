import java.util.*;

public class Kosaraju{


 
    public static void main(String[] args){

        Graph graph = new Graph();
         int[][] matrix = {{1}, {2,3}, {0}, {4}, {}};
        ArrayList<ArrayList<Integer>> list = graph.createGraph(matrix);
        Kosaraju bfs = new Kosaraju();
        ArrayList<Integer> resList = bfs.bfsUtil(list, 5);
        graph.printList(resList);

    }

}
