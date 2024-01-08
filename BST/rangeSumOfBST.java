class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return findSum(root,low,high);
    }
    public int findSum(TreeNode root,int low,int high){
        if(root==null)
            return 0;
        if(root.val<low)
            return findSum(root.right,low,high);
        if(root.val>high)
            return findSum(root.left,low,high);
        return root.val + findSum(root.left,low,high) + findSum(root.right,low,high);
    }
}
