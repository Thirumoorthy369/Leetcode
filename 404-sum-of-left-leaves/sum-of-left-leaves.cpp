/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int sumOfLeftLeaves(TreeNode* root) {
        
        if(root == nullptr) return 0;
        int s = 0;
        
       if(root -> left && root->left->left == NULL && root->left->right == NULL)
       s += root->left->val;
       else s+= sumOfLeftLeaves(root->left);

       s += sumOfLeftLeaves(root->right);
       return s;
    }

    // int Leafnode(TreeNode* root, int s){
    //     if(root == nullptr) return s;
    //     if(root -> left == NULL && root -> right == NULL) {
    //         s += root ->val;
    //     }
    //     Leafnode(root -> left,s);
    //     Leafnode(root -> right, s);
    //     return s;

    // }
};