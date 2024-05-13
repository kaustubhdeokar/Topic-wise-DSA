package tree;

public class SerialiseDeserialise {

    public TreeNode deserialize(String data)
    {
        String[] strArr = data.split(" ");
        int[] count = {0};
        TreeNode head = null;
        head = deserialize(strArr, count);
        return head;
    }

    public TreeNode deserialize(String[] strArr, int[] count)
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
