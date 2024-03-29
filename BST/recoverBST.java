class Solution {
    TreeNode prev = null;
    TreeNode first = null, second = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        if(first==null && prev!=null && prev.val>=root.val){
            first = prev;
        }
        if(first!=null && prev.val>=root.val){
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}
