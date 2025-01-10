package graph.problems;

import graph.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class EulerianCircuit {

    public static void main(String[] args) {

        Graph g = new Graph();
        int[][] circuit = g.sampleEulerianCircuitList();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int[] c: circuit){
            list.add(new ArrayList<>());
            list.get(list.size()-1).add(c[0]);
            list.get(list.size()-1).add(c[1]);
        }

        list.sort((c1,c2)->Integer.compare(Math.abs(c1.get(1)-c2.get(0)), Math.abs(c1.get(0)-c2.get(0))));

        System.out.println(list);
        ArrayList<ArrayList<Integer>> graph = g.createGraph(circuit);


        EulerianCircuit ec = new EulerianCircuit();
        ec.validate(graph);
    }

    private void validate(ArrayList<ArrayList<Integer>> graph) {

        boolean[] visited = new boolean[graph.size()];
        for(int i=0;i<graph.size();i++){
            traverse(graph, i, visited);
        }

    }

    private void traverse(ArrayList<ArrayList<Integer>> graph, int i, boolean[] visited) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        visited[i] = true;

        while(!queue.isEmpty()){

            int curr = queue.remove();
            System.out.println(curr+" ");
            for(int neigh: graph.get(curr)){
                if(!visited[neigh]) {
                    queue.add(neigh);
                }
            }
        }


    }


}
