package trees.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaxProfitPath {

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {

        List<List<Integer>> forest = createForest(edges);
        int nodes = forest.size();
        int[][] visited = new int[nodes][2]; // alice and bob visited
        // traverse for bob from 0th to bob node.
        for(int i=0;i<nodes;i++){
            Arrays.fill(visited[i], -1);
        }

        Stack<int[]> stack = new Stack<>();
        int curr = 0;
        int time = 0;
        stack.push(new int[]{curr, time}); // node time.
        pathToANode(forest, curr, bob, stack, visited);

        while(!stack.isEmpty()){
            int[] top = stack.pop();
            System.out.println(top[0]+":"+top[1]);
        }

        return 0;
    }

    public boolean pathToANode(List<List<Integer>> forest, int curr, int bob, Stack<int[]> stack, int[][] visited)
    {
        int[] top = stack.peek();
        int topNode = top[0];
        int topTime = top[1];
        visited[topNode][1] = topTime;

        if(topNode==bob){
            return true;
        }

        for(int neighbour: forest.get(curr)){
            if(visited[neighbour][1]==-1){
                stack.push(new int[]{neighbour, topTime+1});
                if(pathToANode(forest, neighbour, bob, stack, visited)) return true;
            }
        }
        stack.pop();
        return false;
    }

    public List<List<Integer>> createForest(int[][] edges){
        List<List<Integer>> list = new ArrayList<>();
        int nodes = 0;
        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            nodes = Integer.max(nodes, from);
            nodes = Integer.max(nodes, to);
            int curr = list.size();
            while(curr<=nodes){
                list.add(new ArrayList<>());
                curr+=1;
            }
            list.get(from).add(to);
            list.get(to).add(from);
        }
        return list;
    }

    public static void main(String[] args) {
        MaxProfitPath maxProfitPath = new MaxProfitPath();
        int[][] edges = {{0,1},{1,2},{1,3},{3,4}};
        int[] amount = {-2,4,2,-4,6};
        maxProfitPath.mostProfitablePath(edges, 3, amount);
    }

}
