package trees.binarytree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class TreeNodeToValue {
    TreeNode root;
    int val;

    TreeNodeToValue(TreeNode root, int val) {
        this.root = root;
        this.val = val;
    }
}

public class FindElements {

    // Set   <add values>
    // Queue <root,0>
    // iterate through all and add to set value*2+1 for left child and value*2+2 for right.
    Set<Integer> set = new HashSet<>();


    public FindElements(TreeNode root) {
        Queue<TreeNodeToValue> q = new ArrayDeque<>();
        q.add(new TreeNodeToValue(root, 0));

        while (!q.isEmpty()) {
            TreeNodeToValue top = q.remove();
            TreeNode node = top.root;
            int val = top.val;
            set.add(val);

            if (node.left != null) q.add(new TreeNodeToValue(node.left, val * 2 + 1));
            if (node.right != null) q.add(new TreeNodeToValue(node.right, val * 2 + 2));
        }

        System.out.println(set);

    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

