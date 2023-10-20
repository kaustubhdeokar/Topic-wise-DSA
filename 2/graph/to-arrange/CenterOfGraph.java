package graph;

import graph.Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class CenterOfGraph {

    public static void main(String[] args) {

        int[][] arr = {{1, 2}, {2, 3}, {4, 2}};
        HashMap<Integer, ArrayList<Integer>> graph = new Graph().createGraph(arr,true);
        int numberOfNodes = graph.size();
        System.out.println(numberOfNodes);

    }

}
