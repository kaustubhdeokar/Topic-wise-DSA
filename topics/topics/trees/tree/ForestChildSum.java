package trees.tree;

import java.util.*;

public class ForestChildSum {

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

    public void childSum(ArrayList<TreeNode> forest, int src, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            int top = q.remove();
            visited[top] = true;
            int sum = forest.get(top).data;
            for (int neigh : forest.get(top).getList()) {
                if (!visited[neigh]) {
                    sum += forest.get(neigh).data;
                    q.add(neigh);
                }
            }
            forest.get(top).data = sum;
        }
    }

    private ArrayList<TreeNode> createForest(int n, int[][] edges, int[] values) {
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodeList.add(new TreeNode(values[i]));
            System.out.print(values[i] + " ");
        }
        for (int[] edge : edges) {
            int to = edge[0];
            int from = edge[1];
            nodeList.get(to).getList().add(from);
            nodeList.get(from).getList().add(to);
        }
        System.out.println();
        return nodeList;
    }

    public static void main(String[] args) {

        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int[] values = {3, 0, 6, 1, 5, 2, 1};
        int k = 3;
        int n = 7;
        ForestChildSum forestTraversals = new ForestChildSum();
        ArrayList<TreeNode> forest = forestTraversals.createForest(n, edges, values);
        forestTraversals.childSum(forest, 0, n);
        for (TreeNode t : forest) {
            System.out.print(t.data + " ");
        }
    }


}
