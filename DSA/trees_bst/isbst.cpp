/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int>v;
    bool isValidBST(TreeNode* root) {
        int temp=1;
        if(root==NULL)
            return 1;
        inorder(root,v);
        for(int i=0;i<v.size()-1;i++)
        {
            if(v[i]>=v[i+1])
            {
                temp=0;
                break;
            }
        }
        if(temp==0)
            return false;
        else
            return true;
    }
    void inorder(TreeNode* root,vector<int>&v){
        if(root==NULL)
            return;
        else{
            inorder(root->left,v);
            v.push_back(root->val);
            inorder(root->right,v);
        }
    }
};
