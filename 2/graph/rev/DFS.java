import java.util.*;

public class DFS{


    public ArrayList<Integer> dfsUtil(ArrayList<ArrayList<Integer>> adjList, int vertices){

        ArrayList<Integer> finalResult = new ArrayList<>();
        int[] visited = new int[vertices];
        
        for(int i=0;i<vertices;i++){
             if(visited[i]==0){
                dfsRecursive(adjList, i, visited);
            }
        }   
        
        return finalResult;
    }

    public void dfsRecursive(ArrayList<ArrayList<Integer>> graph, 
                            int currVertex, 
                            int[] visited)
    {
        visited[currVertex] = 1;
        System.out.println(currVertex);

        for(int i=0;i<graph.get(currVertex).size();i++){
            if(visited[graph.get(currVertex).get(i)]==0){
                
                dfsRecursive(graph, graph.get(currVertex).get(i), visited);
            }
        }
    }


    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> list, int vertex, int[] visited){
        visited[vertex] = 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);
        ArrayList<Integer> resultForCurrVertex = new ArrayList<>();

        while(!stack.isEmpty()){
            
            int currVertex = stack.pop();
            

            for(int i=0;i<list.get(currVertex).size();i++){

                if(visited[list.get(currVertex).get(i)]==0){
                    visited[list.get(currVertex).get(i)]=1;
                    stack.push(list.get(currVertex).get(i));
                }
            }
            
            resultForCurrVertex.add(currVertex);

        }
        return resultForCurrVertex;
    }

    public static void main(String[] args){

        Graph graph = new Graph();
        int[][] matrix = {{1, 2}, {0, 2, 3, 4}, {0, 1, 3, 4}, {1, 2}, {1, 2}};
        ArrayList<ArrayList<Integer>> list = graph.createGraph(matrix);
        DFS dfs = new DFS();
        ArrayList<Integer> resList = dfs.dfsUtil(list, 5);
        graph.printList(resList);

    }


}