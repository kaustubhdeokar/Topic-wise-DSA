public class CountPaths{

    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
                   int destination) {
        int[] visited = new int[V];
        ArrayList<Integer> currPath = new ArrayList<>();
        int[] totalPaths = new int[1];
        dfs(adj, visited, source, destination, totalPaths);
        
        return totalPaths[0];
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int currVertex, int destination, int[] totalPaths){
        visited[currVertex] = 1;
        
        if(currVertex == destination){
            totalPaths[0]+=1;
        }
        else{
            for(int adj:graph.get(currVertex)){
                if(visited[adj]==0){
                    dfs(graph, visited, adj, destination, totalPaths);
                }
            }        
        }
        visited[currVertex] = 0;
    }


    public static void main(String[] args){

        Graph graph = new Graph();
        int[][] neighbours = {{1,2,4}, {3,4}, {4}, {2},{}};
        ArrayList<ArrayList<Integer>> list = graph.createGraph(neighbours);
        CountPaths countPaths = new CountPaths();
        countPaths.countPaths(5, list, 0, 4);
    }
}