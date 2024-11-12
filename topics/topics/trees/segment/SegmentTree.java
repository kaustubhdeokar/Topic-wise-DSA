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
            tree[i] = tree[i << 1] + tree[i << 1 | 1];
        }

        return tree;
    }

    public void updateTreeNode(int[] tree, int p, int n, int value) {

        // set value at position p
        tree[p + n] = value;
        p = p + n;

        // move upward and update parents
        for (int i = p; i > 1; i >>= 1)
            tree[i >> 1] = tree[i] + tree[i ^ 1];
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

        int[] arr = {1, 2, 3, 4, 5, 6};
        int n = arr.length;
        int[] tree;
        tree = st.build(arr);
        int res = st.query(2, 6, arr.length, tree);
        System.out.println(res);
        //arr    1 2 3 4
        //total  10


    }
}
