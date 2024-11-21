package graph.disjointset;

public class Practice {
    public static void main(String[] args) {

        int[][] relations = {{1,2},
                {2,4},
                {3,6},
                {3,9},
                {10,5},
                {7,10}};

        int nodes = 10;
        int[] parents = new int[nodes+1];
        for(int i=0;i<parents.length;i++) parents[i] = i;
        int[] ranks = new int[nodes+1];

        for(int[] relation: relations){
            union(relation[0], relation[1], parents, ranks);
        }

        for(int p: parents){
            System.out.print(p+" ");
        }

    }

    private static int findParent(int node, int[] parent){
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node], parent);
    }
    private static void union(int u, int v, int[] parents, int[] ranks) {
        int uPar = findParent(u, parents);
        int vPar = findParent(v, parents);

        if(uPar!=vPar){
            if(ranks[uPar]>ranks[vPar]){
                parents[vPar] = uPar;
            }
            else if(ranks[vPar]>ranks[uPar]){
                parents[uPar] = vPar;
            }
            else{
                parents[uPar] = vPar;
                ranks[uPar]++;
            }
        }

    }
}
