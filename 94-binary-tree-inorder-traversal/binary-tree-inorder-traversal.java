/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public void inorder(TreeNode root, List<Integer>num){
        if(root == null) return;

        inorder(root.left, num);
        num.add(root.val);
        inorder(root.right, num);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> n1 = new ArrayList<>();
        inorder(root, n1);

        return n1;

    }
}