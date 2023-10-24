class Solution {
    public Node connect(Node root) {
        dfs(root);
        return root;
    }
    public void dfs(Node root){
        if(root==null)
            return;
        if(root.left!=null && root.right!=null){
            if(root.next!=null){
                root.right.next = root.next.left;
            }
            root.left.next = root.right;
            dfs(root.left);
            dfs(root.right);
        }     
    }
}
