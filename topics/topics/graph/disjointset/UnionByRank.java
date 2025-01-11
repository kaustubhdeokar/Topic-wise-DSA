package graph.disjointset;

public class UnionByRank {
    private int[] rank;
    private int[] parent;
    int nodes;

    public UnionByRank(int nodes) {
        this.nodes = nodes;
        rank = new int[nodes];
        parent = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            parent[i] = i;
        }
    }

    public void union(int u, int v) {
        int upar = findParent(u);
        int vpar = findParent(v);

        if (upar == vpar) return;
        if (rank[upar] > rank[vpar]) {
            parent[vpar] = upar;
        } else if (rank[upar] < rank[vpar]) {
            parent[upar] = vpar;
        } else {
            parent[upar] = vpar;
            rank[vpar] += 1;
        }

    }

    public int findParent(int node) {
        if (parent[node] == node) return node;

        else {
            //do not suggest.
            int newParent = findParent(parent[node]);
            parent[node] = newParent; //this is called as path compression.
            return newParent;
        }
    }

    public static void main(String[] args) {
        UnionByRank ubr = new UnionByRank(7);
        ubr.union(1, 2);
        ubr.union(2, 3);
        ubr.union(4, 5);
        ubr.union(6, 7);
        ubr.union(5, 6);

        System.out.println(ubr.findParent(3) == ubr.findParent(7));

    }
}
