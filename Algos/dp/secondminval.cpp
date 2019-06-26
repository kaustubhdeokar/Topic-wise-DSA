    set<int>s;
    int findSecondMinimumValue(TreeNode* root) {
        inorder(root,s);
        if(s.size()<2)
            return -1;
        int count=0;
        auto ans=0;
        for(auto x:s)
        {
            ans=x;
            count+=1;
            if(count==2)
                break;
        }
        return ans;
    }
    void inorder(TreeNode* root,set<int>&s){
        if(root==NULL)
            return;
        else{
            inorder(root->left,s);
            s.insert(root->val);
            inorder(root->right,s);
        }
    }

