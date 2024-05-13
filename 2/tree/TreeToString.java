package tree;

public class TreeToString {

    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serialize(root, str);
        return str.toString();
    }

    public void serialize(TreeNode root, StringBuilder str){
        if(root==null){
            str.append("-1001 ");
            return;
        }
        str.append(String.valueOf(root.val)+" ");
        serialize(root.left, str);
        serialize(root.right, str);
    }

    public static void main(String[] args){
        TreeToString treeToString = new TreeToString();
        TreeNode root = treeToString.createTree();
        System.out.println(treeToString.serialize(root));
    }

    public TreeNode createTree() {
        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(20);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(5);
        return root;
    }
}
