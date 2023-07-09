class Solution {
    public int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        if(root.right!=null){
            inorder(root.right);
        }
        sum+=root.val;
        root.val = sum;
        if(root.left!=null){
            inorder(root.left);
        }
    }
}
