package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;

public class SerializeDeserialize {

    public static final String DELIMITER = " ";

    public String serialize(TreeNode tree) {
        ArrayList<String> strList = new ArrayList<>();
        if (tree == null)
            return "";
        levelOrder(tree, strList);
        return String.join(DELIMITER, strList);
    }

    public TreeNode deserialize(String str) {
        String[] strArr = str.split(DELIMITER);
        if (strArr.length == 0 || str.isEmpty())
            return null;
        return constructTree(strArr);
    }

    private TreeNode constructTree(String[] arr) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.push(root);
        int i = 1;

        while (i < arr.length) {

            TreeNode top = queue.remove();

            if (!Objects.equals(arr[i], "null")) {
                top.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(top.left);
            } else {
                top.left = null;
            }
            i += 1;

            if (!Objects.equals(arr[i], "null")) {
                top.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(top.right);
            } else {
                top.right = null;
            }
            i += 1;
        }
        return root;
    }

    public void levelOrder(TreeNode treeNode, ArrayList<String> strList) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        strList.add(String.valueOf(treeNode.val));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.remove();

                if (top.left == null) {
                    nullEntry(strList);
                } else {
                    strList.add(String.valueOf(top.left.val));
                    queue.add(top.left);
                }

                if (top.right == null) {
                    nullEntry(strList);
                } else {
                    strList.add(String.valueOf(top.right.val));
                    queue.add(top.right);
                }

            }
        }
    }

    private void nullEntry(ArrayList<String> list) {
        list.add(null);
    }

}
