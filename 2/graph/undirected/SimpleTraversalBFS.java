import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;

public class SimpleTraversalBFS {

    public static void main(String[] args) {

        int[][] arr = { { 2, 3 }, { 1, 5 }, { 1, 4, 6 }, { 3 }, { 2, 7 }, { 3, 7 }, { 5, 6 } };
        boolean[] visited = new boolean[arr.length + 1];
        SimpleTraversalBFS graph = new SimpleTraversalBFS();

        for (int i = 1; i <= arr.length; i++) {
            if (!visited[i]) {
                System.out.println("looping for :" + i);
                graph.bfs(arr, visited, i);
            }
        }
    }

    public void bfs(int[][] arr, boolean[] visited, int curr) {

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(curr);

        while (!q.isEmpty()) {
            int top = q.remove();
            
            if (visited[top] == true) {
                System.out.println("already visited" + top);
            } else {
                visited[top] = true;
                System.out.println("visiting:" + top);
            }
            for (int adj : arr[top - 1]) {
                if (!visited[adj]) {
                    q.add(adj);
                }
            }
        }

    }

}
