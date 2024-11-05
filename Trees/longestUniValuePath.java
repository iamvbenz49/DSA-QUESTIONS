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
    private int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        return  Math.max(dfs(root), res);
    }
    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        int leftPath = 0, rightPath = 0;
        if(root.left != null && root.left.val == root.val) {
            leftPath = left + 1;
        }
        if(root.right != null && root.right.val == root.val) {
            rightPath = right + 1;
        }
        res = Math.max(res, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}