 public boolean isSameTree(TreeNode p, TreeNode q) {
        
     	//if only either of the trees is null, -> false.
        if((p==null && q!=null)||(p!=null && q==null))
            return false;
        
        // both null -> cool -> return true.
        if(p==null && q==null)
            return true;
            
        // value not equal false
        if(p.val!=q.val)
            return false;
        
        //continue to compare in subtrees.
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
