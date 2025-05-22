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
}
 */
class Solution {
    int xDepth = -1;
    int yDepth = -1;
    TreeNode xParent = null;
    TreeNode yParent = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return xDepth == yDepth && xParent != yParent;
    }

    private void dfs(TreeNode node, TreeNode parent, int depth, int x, int y) {
        if (node == null) return;

        if (node.val == x) {
            xDepth = depth;
            xParent = parent;
        } else if (node.val == y) {
            yDepth = depth;
            yParent = parent;
        }

        // Continue searching in left and right subtree
        dfs(node.left, node, depth + 1, x, y);
        dfs(node.right, node, depth + 1, x, y);
    }
}