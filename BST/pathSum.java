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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root,targetSum);
    }
    public boolean pathSum(TreeNode root, int target){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            if(target-root.val==0){
                return true;
            }
            else{
                return false;
            }
        }
        return pathSum(root.left,target-root.val) || pathSum(root.right,target-root.val);
    }
}
