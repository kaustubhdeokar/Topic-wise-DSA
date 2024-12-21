package trees.tree;

import java.util.*;

public class ForestTraversals {

    class TreeNode {
        int data;
        List<Integer> list;

        public TreeNode(int data) {
            this.data = data;
            list = new ArrayList<>();
        }

        public List<Integer> getList() {
            return list;
        }
    }

    public void bfsOnForest(ArrayList<TreeNode> forest, int src, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            int top = q.remove();
            visited[top] = true;
            System.out.print(top + " ");
            for (int neigh : forest.get(top).getList()) {
                if(!visited[neigh]){
                    q.add(neigh);
                }
            }
        }
    }

    public void dfsOnForest(ArrayList<TreeNode> forest, int src, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.add(src);
        boolean[] visited = new boolean[n];
        while (!stack.isEmpty()) {
            Integer top = stack.pop();
            visited[top] = true;
            System.out.print(top + " ");
            for (int neigh : forest.get(top).getList()) {
                if(!visited[neigh]){
                    stack.push(neigh);
                }
            }
        }
    }

    private ArrayList<TreeNode> createForest(int n, int[][] edges, int[] values) {
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodeList.add(new TreeNode(values[i]));
        }
        for (int[] edge : edges) {
            int to = edge[0];
            int from = edge[1];
            nodeList.get(to).getList().add(from);
            nodeList.get(from).getList().add(to);
        }
        return nodeList;
    }

    public static void main(String[] args) {

        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
        int[] values = {3,0,6,1,5,2,1};
        int k = 3;
        int n = 7;
        ForestTraversals forestTraversals = new ForestTraversals();
        ArrayList<TreeNode> forest = forestTraversals.createForest(n, edges, values);
        forestTraversals.dfsOnForest(forest, 0, n);
        System.out.println();
        forestTraversals.bfsOnForest(forest, 0, n);
    }


}
