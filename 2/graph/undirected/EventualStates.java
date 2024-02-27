//point of this being that we find vertex from which no cycles are found. 
// safe states -> vertexes with no cycles.

public class EventualStates {

    public static void main(String[] args) {

        // [[0],[2,3,4],[3,4],[0,4],[]]

        int[][] graph = { { 0 }, { 2, 3, 4 }, { 3, 4 }, { 0, 4 }, {} };
        int nodes = graph.length;
        int[] eventualStates = new int[nodes];
        int[] visited = new int[nodes];
        int[] recStack = new int[nodes];

        for (int i = 0; i < nodes; i++) {
            if (visited[i] == 0) {
                isCycle(graph, i, visited, recStack, eventualStates);
            }
        }

        for (int i : eventualStates) {
            System.out.print(i + " ");
        }

    }

    public static boolean isCycle(int[][] graph, int vertex, int[] visited, int[] recStack, int[] eventualStates) {

        System.out.println("curr:" + vertex);
        visited[vertex] = 1;
        recStack[vertex] = 1;

        for (int adjacent : graph[vertex]) {
            if (visited[adjacent] == 0) {
                if(isCycle(graph, adjacent, visited, recStack, eventualStates)){
                    return true;
                }
            } 
            else if(recStack[adjacent] == 1) {
                return true;
            } 
        }
        recStack[vertex] = 0;
        eventualStates[vertex] = 1;
        
        return false;
    }

}
