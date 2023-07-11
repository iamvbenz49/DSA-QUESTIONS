class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return sum(root.left,root,null)+sum(root.right,root,null);
    }
    public int sum(TreeNode root,TreeNode parent,TreeNode grandParent){
        if(root==null){
            return 0;
        }
        if(grandParent!=null && grandParent.val%2==0){
            return root.val + sum(root.left,root,parent)+sum(root.right,root,parent);
        }
        return sum(root.left,root,parent)+sum(root.right,root,parent);
    }
}
