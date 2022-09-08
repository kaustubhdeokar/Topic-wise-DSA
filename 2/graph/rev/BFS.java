import java.util.*;

public class BFS{


    public ArrayList<Integer> bfsUtil(ArrayList<ArrayList<Integer>> list, int vertices){

        ArrayList<Integer> resultList = new ArrayList<>();
        Graph graph = new Graph();
        int[] visited = new int[vertices];
        
        for(int i=0;i<vertices;i++){
            if(visited[i]==0){
                ArrayList<Integer> resultForI = bfs(i, list, visited);
                resultList.addAll(resultForI);
            }
        }

        return resultList;

    }

    public ArrayList<Integer> bfs(int currVertex, ArrayList<ArrayList<Integer>> list, int[] visited){
        
        ArrayList<Integer> bfsOrder = new ArrayList<>();
        
        visited[currVertex] = 1;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(currVertex);

        while(!queue.isEmpty()){
            
            currVertex = queue.remove();
            for(int i=0;i<list.get(currVertex).size();i++){
                if(visited[list.get(currVertex).get(i)]==0){
                    visited[list.get(currVertex).get(i)] = 1;
                    queue.add(list.get(currVertex).get(i));
                }
            }
            bfsOrder.add(currVertex);
        }

        return bfsOrder;

    }

    public static void main(String[] args){

        Graph graph = new Graph();
        int[][] matrix = {{1, 2}, {0, 2, 3, 4}, {0, 1, 3, 4}, {1, 2}, {1, 2}};
        ArrayList<ArrayList<Integer>> list = graph.createGraph(matrix);
        BFS bfs = new BFS();
        ArrayList<Integer> resList = bfs.bfsUtil(list, 5);
        graph.printList(resList);

    }

}
