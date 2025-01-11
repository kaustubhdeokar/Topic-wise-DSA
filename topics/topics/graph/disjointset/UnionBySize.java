package graph.disjointset;

public class UnionBySize {

    private int[] parent;
    private int[] size;
    int nodes;

    public UnionBySize(int nodes) {
        this.nodes = nodes;
        size = new int[nodes + 1];
        parent = new int[nodes + 1];
        for (int i = 0; i <= nodes; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int node) {
        if (parent[node] == node) return node;

        else {
            int newParent = findParent(parent[node]);
            parent[node] = newParent; //this is called as path compression.
            return newParent;
        }
    }

    // during path compression we might decrease the rank of the parent node/
    //     4
    //    / \
    //   1   5
    //  /     \
    // 2       7

    // if we find the ultimate parent of 7 , we reach 4, by path compression, the tree would be
    //      4
    //    / \ \
    //   1   5 7
    //  /
    // 2
    // still have the rank preserved, so we cannot say for sure.

    public void unionBySize(int u, int v) {
        int upar = findParent(u);
        int vpar = findParent(v);

        if (upar == vpar) return;
        if (size[upar] > size[vpar]) {
            parent[vpar] = upar;
            size[upar] += size[vpar];
        } else {
            parent[upar] = vpar;
            size[vpar] += size[upar];
        }
    }


    public static void main(String[] args) {
        UnionBySize ubs = new UnionBySize(7);
        ubs.unionBySize(1, 2);
        ubs.unionBySize(2, 3);
        ubs.unionBySize(4, 5);
        ubs.unionBySize(6, 7);
        ubs.unionBySize(5, 6);

        System.out.println(ubs.findParent(3) == ubs.findParent(7));
        ubs.unionBySize(3, 7);
        System.out.println(ubs.findParent(3) == ubs.findParent(7));

    }


}
