import java.util.ArrayList;

public class Cycle {


    /*
      
        1  ->  2
        ^      ^ 
        |      |
        3  <-  4 
        
    */
    public static void main(String[] args) {
        int[][] arr = {{}, {2}, {4}, {1}, {3}};
        System.out.println("Has cycle :" + detectCycle(arr));
    }

    private static boolean detectCycle(int[][] graph) {
        
        int[] visited = new int[graph.length];
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (traverse(graph, visited, i, -1)){
                    return true;
                }
                visited[i] = 0;//change made for working with directed graph.
            }
        }
        return false;
    }

    private static boolean traverse(int[][] graph, int[] visited, int vertex, int parent) {
        
        System.out.println("v:"+vertex+" parent:"+parent);

        for(int adjacent: graph[vertex]){

            System.out.println("adj:"+adjacent);

            if(visited[adjacent] == 0){
                visited[adjacent] = 1;
                boolean ans = traverse(graph, visited, adjacent, vertex);
                visited[adjacent] = 0; //change made for working with directed graph.
                return ans;
            }
            else{
                if(parent!=adjacent){
                    System.out.println("returning true:");
                    return true;
                }
            }
        }
    
        return false;
        
    }

}
