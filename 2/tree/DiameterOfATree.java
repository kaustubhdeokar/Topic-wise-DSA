package tree;

public class DiameterOfATree{
    
    public int diameterOfATree(TreeNode treeNode){

        if(treeNode == null)
            return 0;
        
        int[] diameter = {-1};

        findHeightOfNode(treeNode, diameter);

        return diameter[0];
    }

    public int findHeightOfNode(TreeNode treeNode, int[] diameter){

        if(treeNode==null){
            return 0;
        }

        int heightOfLeftNode = findHeightOfNode(treeNode.left, diameter);
        int heightOfRightNode = findHeightOfNode(treeNode.right, diameter);

        
        diameter[0] = Integer.max(diameter[0], heightOfLeftNode + heightOfRightNode + 1);
        
        //System.out.println("node:"+treeNode.val+" left node height:"+heightOfLeftNode+" right node height:"+ heightOfRightNode);
        //System.out.println("diameter:"+diameter[0]);

        return Integer.max(heightOfLeftNode, heightOfRightNode)+1;
    }

    public static void main(String[] main){
        TreeNode rootNode = new TreeNode();
        DiameterOfATree d = new DiameterOfATree();
        System.out.println("final answer"+d.diameterOfATree(rootNode.buildTree2()));
    
    }
}