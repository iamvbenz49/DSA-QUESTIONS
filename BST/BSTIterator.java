TC - O(N) SC - O(H)
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

// TC - O(1) SC - O(N)
class BSTIterator {
    List<Integer> list;
    int idx;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.add(root);
        while(!stack.isEmpty()){
            if(node!=null && node.left!=null){
                stack.add(node.left);
                node = node.left;
            }else{
                node = stack.pop();
                list.add(node.val);
                if(node.right!=null){
                    stack.add(node.right);
                    node = node.right;
                }else{
                    node = null;
                }
            }
        }
        idx = 0;
    }
    
    public int next() {
        return list.get(idx++);
    }
    
    public boolean hasNext() {
        return list.size()!=idx;
    }
}
