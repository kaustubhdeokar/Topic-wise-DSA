#define max(a,b) ((a>b)?a:b)

class Solution {
public:
    bool isBalanced(TreeNode* root) {
       int temp=1;
        isBal(root,&temp);
        if(temp==1)
            return true;
        else
            return false;
    }
    
    void isBal(TreeNode* root,int* temp){
        if(root==NULL)
            return;
        else{
            int l=height(root->left);
            int r=height(root->right);
            if(abs(l-r)>1)
            {
                 *temp=0;
                 return;
            }   
            else{
                isBal(root->left,temp);
                isBal(root->right,temp);
            }
            
        }
    }
    
    int height(TreeNode* root){
        if(root==NULL)
            return 0;
        else{
            int l=height(root->left);
            int r=height(root->right);
            return max(l,r)+1;
        }
    }
};
