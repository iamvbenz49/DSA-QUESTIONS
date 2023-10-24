class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        dfs(root);
    }
    public void dfs(TreeNode root){
        if(root==null)
            return;

        dfs(root.right);
        dfs(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }
}
