import java.util.ArrayDeque;

public class MergeTrees {

    public Node mergeTrees(Node root1, Node root2) {

        // traversal -> in order.
        // tree 2 merged into tree 1,
        // so if tree 1 curr node is null, create new node from value of tree2.

        // if both null, return null
        // if tree2 null, return tree1 root.
        // if tree1 null, create new root of tree2.
        // both present, add both nodes.

        if (root1 == null && root2 == null)
            return null;
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    public static Node formNode2() {

        /*
         * 7
         * / \
         * 2 9
         * / \ / \
         * 1 8 10
         * 
         * 
         */
        Node root = new Node(7);
        root.left = new Node(2);
        root.right = new Node(9);

        root.left.left = new Node(1);
        // root.left.right = new Node(4);

        root.right.left = new Node(8);
        root.right.right = new Node(10);

        // root.left.right.left = new Node(3);
        // root.left.right.right = new Node(5);

        return root;

    }

    public static Node formNode1() {

        /*
         * 1
         * / \
         * 2 3
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        return root;

    }

    public static void main(String[] args) {

        MergeTrees mergeTrees = new MergeTrees();
        Node one = formNode1();
        Node two = formNode2();
        Node ans = mergeTrees.mergeTrees(one, two);
        mergeTrees.printLevelOrder(ans);
    }

    public void printLevelOrder(Node node) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(node);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.pop();
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
                System.out.print(curr.val + " ");
            }
            System.out.println();
        }
    }

}
