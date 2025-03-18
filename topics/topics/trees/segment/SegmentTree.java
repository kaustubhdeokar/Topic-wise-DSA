package trees.segment;

@SuppressWarnings("ManualArrayCopy")
public class SegmentTree {

    public int[] build(int[] arr) {

        int n = arr.length;
        int[] tree = new int[2 * n];

        for (int i = 0; i < n; i++) {
            tree[n + i] = arr[i];
        }

        for (int i = n - 1; i > 0; --i) {
//            System.out.println(tree[i << 1] + " " + tree[i << 1 | 1]);
            tree[i] = Integer.max(tree[i << 1], tree[i << 1 | 1]);
        }

        return tree;
    }

    public void updateTreeNode(int[] tree, int p, int n, int value) {

        if (tree[p + n] >= value) tree[p + n] -= value;
        p = p + n;

        // move upward and update parents
        for (int i = p; i > 1; i >>= 1)
            tree[i >> 1] = Integer.max(tree[i], tree[i ^ 1]);
    }


    static int query(int l, int r, int n, int[] tree) {
        int res = 0;

        // loop to find the sum in the range
        for (l += n, r += n; l < r;
             l >>= 1, r >>= 1) {
            if ((l & 1) > 0)
                res += tree[l++];

            if ((r & 1) > 0)
                res += tree[--r];
        }

        return res;
    }

    public static void main(String[] args) {
        SegmentTree st = new SegmentTree();

        int[] nums = {1,2, 3, 2, 1};
        int[] tree = st.build(nums);
        for (int a : tree) {
            System.out.print(a + " ");
        }
        System.out.println();

        int[][] queries = {{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 4, 1}};
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int val = query[2];
            for (int j = start; j <= end; j++) {
                st.updateTreeNode(tree, j, nums.length, val);
            }
            //max of the whole array -> tree[1]
            System.out.println("max:"+tree[1]);
        }

        for (int i = nums.length; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }

    }
}
