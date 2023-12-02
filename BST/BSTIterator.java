class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        stackAdder(node);
    }
    
    public int next() {
        TreeNode node = stack.pop();
        if(node.right!=null)    
            stackAdder(node.right);
        return node.val;
    }
    public void stackAdder(TreeNode root){
        while(root!=null){
            stack.add(root);
            root = root.left;
        }
    }
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
