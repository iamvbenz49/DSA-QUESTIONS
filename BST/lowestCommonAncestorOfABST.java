class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root,p,q);
    }
    public TreeNode LCA(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)
            return null;
        if(p.val>root.val && q.val>root.val)
            return LCA(root.right,p,q);
        if(p.val<root.val && q.val<root.val)
            return LCA(root.left,p,q);
        return root;
    }
}
