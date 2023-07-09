class Solution {
    public int sum = 0;
    public int maxDepth = 0; 
    public int deepestLeavesSum(TreeNode root) {
        dfs(root,0);
        return sum;
    }
    public void dfs(TreeNode root,int depth){
        if(root==null){
            return;
        }
        if(depth==maxDepth){
            sum+=root.val;
        }
        if(depth>maxDepth){
            sum = root.val;
            maxDepth = depth;
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}
