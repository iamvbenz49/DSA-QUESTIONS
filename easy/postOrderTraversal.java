/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//using ITERATION
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)return list;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        stack1.add(root);
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        while(!stack1.isEmpty()){
            TreeNode curr = stack1.pop();
            stack2.add(curr);
            if(curr.left!=null)stack1.add(curr.left);
            if(curr.right!=null)stack1.add(curr.right);
        }
        while(!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }
        return list;
    }
}

//USING RECURSION
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>(); 
        traversal(root,list);
        return list;
    }
    public void traversal(TreeNode root,List<Integer> list){
        if(root==null) return;
        if(root.left!=null) traversal(root.left,list);
        if(root.right!=null) traversal(root.right,list);
        list.add(root.val);
    }
}
