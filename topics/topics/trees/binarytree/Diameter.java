package trees.binarytree;

import trees.TreeNode;

public class Diameter {
    int diameter(TreeNode node) {
        TreeNode maxDiameter = null;
        int[] maxDiameterLength = new int[]{0};
        height(node, maxDiameter, maxDiameterLength);
        if (maxDiameter != null) {
            System.out.println("max diameter node:" + maxDiameter.val + ":");
        }
        return maxDiameterLength[0];
    }

    int height(TreeNode node, TreeNode maxDiameter, int[] maxDiameterLength) {
        if (node == null) return 0;
        int h = 1 + height(node.left, maxDiameter, maxDiameterLength) + height(node.right, maxDiameter, maxDiameterLength);
        if (h > maxDiameterLength[0]) {
            maxDiameterLength[0] = h;
            maxDiameter = node;
        }
        return h;
    }


    public static void main(String[] args) {
        Diameter diameter = new Diameter();
    }

}
