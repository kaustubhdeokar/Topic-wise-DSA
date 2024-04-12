

import tree.TreeNode;

public class CompareTrees {
    
    public boolean compare(TreeNode root, TreeNode deserializedRoot) {
        if(root==null && deserializedRoot==null)
            return true;
        if(root==null || deserializedRoot==null)
            return false;

        if(root.val != deserializedRoot.val)
            return false;

        return compare(root.left, deserializedRoot.left) && compare(root.right, deserializedRoot.right);

    }
}
