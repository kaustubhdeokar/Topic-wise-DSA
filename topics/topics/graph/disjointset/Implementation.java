package graph.disjointset;

public class Implementation {

    private int[] rank;
    private int[] parent;
    private int[] size;
    int nodes;

    public Implementation(int nodes) {//7
        this.nodes = nodes;
        rank = new int[nodes + 1];
        size = new int[nodes + 1];
        parent = new int[nodes + 1];
        for (int i = 0; i <= nodes; i++) {
            parent[i] = i;
        }

    }

    //  7 -> 4 -> 1
    //  4    1    1

    public int findParent(int node) {
        if (parent[node] == node) return node;

        else {
            //do not suggest.
            int newParent = findParent(parent[node]);
            parent[node] = newParent;
            return newParent;
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

    public void unionBySize(int u, int v) {
        int upar = findParent(u);
        int vpar = findParent(v);

        if (upar == vpar) return;
        if (size[upar] > rank[vpar]) {
            parent[vpar] = upar;
            size[upar] += size[vpar];
        } else {
            parent[upar] = vpar;
            size[vpar] += size[upar];
        }
    }


    public static void main(String[] args) {
        Implementation implementation = new Implementation(7);
//        unionByRank(implementation);
        unionBySize(implementation);

        int[] parent1 = implementation.parent;
        System.out.println(implementation.findParent(3) == implementation.findParent(7));
        for (int p : parent1) {
            System.out.print(p + " ");
        }
        implementation.union(3, 7);
        System.out.println(implementation.findParent(3) == implementation.findParent(7));
        System.out.println();
        for (int p : parent1) {
            System.out.print(p + " ");
        }
    }

    private static void unionByRank(Implementation implementation) {
        implementation.union(1, 2);
        implementation.union(2, 3);
        implementation.union(4, 5);
        implementation.union(6, 7);
        implementation.union(5, 6);
    }

    private static void unionBySize(Implementation implementation) {
        implementation.unionBySize(1, 2);
        implementation.unionBySize(2, 3);
        implementation.unionBySize(4, 5);
        implementation.unionBySize(6, 7);
        implementation.unionBySize(5, 6);
    }

}
