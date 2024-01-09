class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        s1.add(root1);
        s2.add(root2);
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(dfs(s1)!=dfs(s2))return false;
        }
        return s1.isEmpty() && s2.isEmpty();
    }
    public int dfs(Stack<TreeNode> stack){
        while(true){
            TreeNode node = stack.pop();
            if(node.left!=null) stack.push(node.left);
            if(node.right!=null) stack.push(node.right);
            if(node.left==null && node.right==null) return node.val; 
        }
    }
}
