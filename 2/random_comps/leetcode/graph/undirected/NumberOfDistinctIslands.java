package graph.undirected;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class NumberOfDistinctIslands {

    public static void main(String[] args) {

        NumberOfDistinctIslands distinct = new NumberOfDistinctIslands();
        
        int[][] grid = {
                {1, 1, 1, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 1, 1, 1}
                };

        distinct.countDistinctIslands(grid);

    }

    public int countDistinctIslands(int[][] grid) {

        Set<Integer> distinctIslands = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                if (grid[i][j] == 1) {
                    Map<Integer, List<Integer>> map = new HashMap<>();    
                    extractIslandDetails(grid, i, j, map);
                    int total = 0;
                    int row = 1;
                    for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
                        System.out.println(entry.getKey()+":"+entry.getValue());
                        total += row * (entry.getValue().size()+row);
                        row+=1;
                    }
                    distinctIslands.add(total);
                    System.out.println(total);
                }
                
            }
        }
        return distinctIslands.size();
    }

    public void extractIslandDetails(int[][] grid, int i, int j, Map<Integer, List<Integer>> map) {

        if (isValid(grid, i, j)) {
            if(map.get(i)==null){
                map.put(i,new ArrayList<>());
            }
            grid[i][j] = 2;
            map.get(i).add(j);
            
            extractIslandDetails(grid, i+1, j, map);
            extractIslandDetails(grid, i-1, j, map);
            extractIslandDetails(grid, i, j+1, map);
            extractIslandDetails(grid, i, j-1, map);

        }

    }

    public boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1;
    }

}
