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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) binaryfind(root, "", res);
        return res;
    }

    public void binaryfind(TreeNode root, String a, List<String>re){
        if(root.left == null && root.right == null) re.add(a+root.val);
        if(root.left != null)  binaryfind(root.left, a + root.val + "->", re);
        if(root.right != null)  binaryfind(root.right, a + root.val + "->", re);
    }
}