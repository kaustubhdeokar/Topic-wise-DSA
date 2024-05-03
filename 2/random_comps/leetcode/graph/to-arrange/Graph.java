import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;

public class Graph {

    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

    public ArrayList<ArrayList<Integer>> createGraph(int[][] arr) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new ArrayList<>());
            for (int j : arr[i])
                list.get(i).add(j);
        }
        return list;
    }



    public ArrayList<ArrayList<Pair>> createGraphWithWeights(int[][] arr, int vertices) {

        ArrayList<ArrayList<Pair>> list = new ArrayList<>();

        for (int i = 0; i < vertices; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < arr.length; i++) {
            list.get(arr[i][0]).add(new Pair(arr[i][1], arr[i][2]));
        }
        return list;
    }

    public HashMap<Integer, ArrayList<Integer>> createGraph(int[][] arr, boolean isBidirectional) {
        for (int i = 0; i < arr.length; i++) {

            int key = arr[i][0];
            int value = arr[i][1];

            addToGraph(key, value);
            if (isBidirectional) {
                addToGraph(value, key);
            }
        }
        return graph;
    }

    public void addToGraph(int key, int value) {
        if (graph.get(key) != null) {
            graph.get(key).add(value);
        } else {
            graph.put(key, new ArrayList<>() {{
                add(value);
            }});
        }
    }

}
