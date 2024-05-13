package tree;

/*
    this represents tree in preorder form. it depicts all null nodes.
    null node is depicted by -1001.
*           1
*          / \
*         2   3

 this will be represented as 1 2 -1001 -1001 3 -1001 -1001
 given the above input string, a tree will be formed.
* */

public class StringToTree {

    public TreeNode deserialize(String data)
    {
        String[] strArr = data.split(" ");
        int[] count = {0};
        TreeNode head = null;
        head = deserialize(strArr, count);
        return head;
    }

    private TreeNode deserialize(String[] strArr, int[] count)
    {
        if(strArr[count[0]].equals("-1001"))
        {
            count[0]+=1;
            return null;
        }
        TreeNode curr = new TreeNode(Integer.parseInt(strArr[count[0]++]));
        curr.left = deserialize(strArr, count);
        curr.right = deserialize(strArr, count);
        return curr;
    }

    public static void main(String[] args){

        TreeToString tree = new TreeToString();
        TreeNode node = tree.createTree();
        String serialize = tree.serialize(node);
        StringToTree treeToString = new StringToTree();
        TreeNode deserializedNode = treeToString.deserialize(serialize);
        deserializedNode.levelOrder(deserializedNode);
    }

}
