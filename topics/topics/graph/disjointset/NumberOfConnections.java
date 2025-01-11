package graph.disjointset;

//https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
public class NumberOfConnections {

    public int makeConnected(int n, int[][] connections) {

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] rank = new int[n];
        if(connections.length < n-1) return -1;
        int need = 0;
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            need += makeConnection(parent, rank, u, v);
        }
        return n - need - 1;
    }

    private int makeConnection(int[] parent, int[] rank, int u, int v) {

        int upar = findParent(u, parent);
        int vpar = findParent(v, parent);

        if (upar == vpar) return 0;

        if (rank[upar] > rank[vpar]) {
            parent[vpar] = parent[upar];
        } else if (rank[upar] < rank[vpar]) {
            parent[upar] = parent[vpar];
        } else {
            parent[vpar] = parent[upar];
            rank[upar] += 1;
        }

        return 1;
    }

    private int findParent(int node, int[] parent) {
        if (parent[node] == node) return node;

        int newParent = findParent(parent[node], parent);
        parent[node] = newParent;
        return newParent;
    }

}
