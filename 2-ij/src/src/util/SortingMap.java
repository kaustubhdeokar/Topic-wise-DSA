package tree;

import java.util.*;

public class SortingMap {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serialize(root, str);
        System.out.println(str.toString());
        return str.toString();
    }
    public void serialize(TreeNode root, StringBuilder str){
        if(root==null){
            str.append("-1 ");
            return;
        }
        str.append(String.valueOf(root.val)+" ");
        serialize(root.left, str);
        serialize(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArr = data.split(" ");
        int[] count = {0};
        TreeNode head = null;
        head = deserialize(strArr, count);
        return head;
    }

    public TreeNode deserialize(String[] strArr, int[] count){

        if(strArr[count[0]].equals("-1")){
            count[0]+=1;
            return null;
        }
        TreeNode curr = new TreeNode(Integer.parseInt(strArr[count[0]++]));
        curr.left = deserialize(strArr, count);
        curr.right = deserialize(strArr, count);
        return curr;
    }

    public static void main(String[] args) {

        String str = "1 2 -1 -1 3 4 -1 -1 5 -1 -1";
        SortingMap sortingMap = new SortingMap();
        TreeNode deserialize = sortingMap.deserialize(str);
        deserialize.levelOrder(deserialize);
    }

}
