class Solution {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        return Math.max(dfs(root)-1,maxDiameter);
    }
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        maxDiameter = Math.max(maxDiameter,left+right);

        return 1 + Math.max(left,right);
    }
}
