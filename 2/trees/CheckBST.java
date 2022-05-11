	boolean checkBST(TreeNode root) {
		if(root==null)
			return true;
		return checkBSTInLimit(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	public boolean checkBSTInLimit(TreeNode root, int lowerLimit, int upperLimit){

		if(root==null)
			return true;

		if(root.data> lowerLimit && root.data< upperLimit){
			return checkBSTInLimit(root.left,lowerLimit,root.data) && checkBSTInLimit(root.right,root.data,upperLimit);
		}
		else
			return false;
	}
