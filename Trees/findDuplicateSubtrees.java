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
    List<TreeNode> res;
    Map<String, Integer> map;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new ArrayList<>();
        map = new HashMap<>();
        dfs(root);
        return res;
    }
    public String dfs(TreeNode root) {
        if(root == null) {
            return "";
        }

        String left = dfs(root.left);
        String right = dfs(root.right);

        String current = root.val + " " + left + " " + right; 

        map.put(current, map.getOrDefault(current, 0) + 1);
        if(map.get(current) == 2) 
            res.add(root);
        return current;
    } 
}
